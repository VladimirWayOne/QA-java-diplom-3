# Третье задание дипломного проекта
## Необходимо проверить

### Регистрация

- Успешную регистрацию. Поле «Имя» должно быть не пустым; в поле Email введён email в формате логин@домен:
  например, ```123@ya.ru```. Минимальный пароль — шесть символов.
- Ошибку для некорректного пароля.

[RegistrationTest.java](src%2Ftest%2Fjava%2FRegistrationTest.java)
[ErrorMessageTest.java](src%2Ftest%2Fjava%2FErrorMessageTest.java)
### Вход

- вход по кнопке «Войти в аккаунт» на главной,
- вход через кнопку «Личный кабинет»,
- вход через кнопку в форме регистрации,
- вход через кнопку в форме восстановления пароля.

[LoginTest.java](src%2Ftest%2Fjava%2FLoginTest.java)
### Переход в личный кабинет

- переход по клику на «Личный кабинет».

[TransitionTest.java](src%2Ftest%2Fjava%2FTransitionTest.java)
### Переход из личного кабинета в конструктор

- переход по клику на «Конструктор» и на логотип Stellar Burgers.

[TransitionTest.java](src%2Ftest%2Fjava%2FTransitionTest.java)
### Выход из аккаунта

- выход по кнопке «Выйти» в личном кабинете.

[LogoutTest.java](src%2Ftest%2Fjava%2FLogoutTest.java)
### Раздел «Конструктор»

Проверь, что работают переходы к разделам:

* «Булки»,
* «Соусы»,
* «Начинки».

[ConstructorTest.java](src%2Ftest%2Fjava%2FConstructorTest.java)