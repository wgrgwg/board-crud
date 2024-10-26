# board-crud

CRUD 기능을 구현한 간단한 게시판 프로그램 구현

## 세부 사항

### 1단계

- 각 명령어를 ENUM class로 선언 -> 편하게 기능을 분류, `switch`도 깔끔해짐

### 2단계

- 모델에 따라서 크게 세 가지로 분류 : `Board`, `Post`, `Account`
    - MVC 패턴에 맞게 각각 model, view, controller 생성
    - 또한, 전체적인 프로그램 흐름을 다루는 `ProgramController`, `ProgramView` 생성
- URL의 요소들을 ENUM type으로 선언
    - 구분
    - 기능
- 생성한 Request의 Type에 따라 `Board`, `Post`, `Account` 로 분류
    - 구현한 기능을 찾기 쉬움
- 모델 별로 각각 `toString()` 구현
    - view에서 해당 모델 객체를 출력할 때, 각각 인자를 넣어줘야 하는 등 복잡해짐
    - 출력 형식에 따라 `toString` 함수로 구현, 편하게 인자로 넘겨줌

## 트러블 슈팅

### 1단계

- 정수가 아닌 id 값 입력 받은 경우, 예외 처리
- `validatePostIdExists`
    - 입력받은 id가 존재하는 게시글인지 검사
    - validate 클래스에서 하고 싶지만 post 모델에 접근해야함
    - PostService를 validator가 접근?
        - **그냥 controller에서 validate하는 것으로 구현**

### 2단계

#### URL Validation

- URL -> Request 객체 생성할 때 유효성 검사
    - 입력받은 String 파싱 과정에서 **요소 별로 검사**
- 구분, 기능에 따라 맞는 파라미터가 정해져 있음 검사 복잡해짐
    - Constant에 올바른 `구분-기능-파라미터키`가 묶인 **Map**을 선언
- 단순 URL 형식 유효성 검사와 모델의 데이터와 관련된 유효성 검사 구분
    - **URL** : Validator
    - **데이터에 접근** : 각 모델의 Controller

#### MVC Pattern

- 모델 별로 각각 model, view, controller 생성
    - Application의 `main` 함수에서 **복잡한 생성자**

#### `Post` - `Board` 관계

- `Board`와 `Post`는 복잡하게 연결되어 있음
- 필드로 `Board`는 `List<Post>`를 갖고, `Post`는 `Board`를 갖음
    - 일단 controller 단에서 각각의 service를 호출해서 해결
    - 해결 방법?