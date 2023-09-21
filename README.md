<p align="center">
<a href="https://www.wildberries.ru/"> <img width=50%" src="src/media/wildberries-logo.png"> </a></h1>
<p align="center">

# <p align="center"> Проект по автоматизации тестовых сценариев для  Wildberries <p align="center">
## :pushpin: Содержание:

- [Использованный стек технологий](#computer-использованный-стек-технологий)
- [Запуск тестов из терминала](#arrow_forward-запуск-тестов-из-терминала)
- [Сборка в Jenkins](#сборка-в-jenkins)
- [Пример Allure-отчета](#пример-allure-отчета)
- [Уведомления в Telegram с использованием бота](#уведомления-в-telegram-с-использованием-бота)
- [Видео примера запуска тестов в Selenoid](#-видео-примера-запуска-теста-в-selenoid)

## :computer: Использованный стек технологий
<p align="center">
<img width="6%" title="IntelliJ IDEA" src="src/media/Intelij_IDEA.svg">
<img width="6%" title="Java" src="src/media/Java.svg">
<img width="6%" title="Selenide" src="src/media/Selenide.svg">
<img width="6%" title="Selenoid" src="src/media/Selenoid.svg">
<img width="6%" title="Allure Report" src="src/media/Allure_Report.svg">
<img width="5%" title="Allure TestOps" src="src/media/AllureTestOps.svg">
<img width="6%" title="Gradle" src="src/media/Gradle.svg">
<img width="6%" title="JUnit5" src="src/media/JUnit5.svg">
<img width="6%" title="GitHub" src="src/media/GitHub.svg">
<img width="6%" title="Jenkins" src="src/media/Jenkins.svg">
<img width="6%" title="Telegram" src="src/media/Telegram.svg">
<img width="5%" title="Jira" src="src/media/Jira.svg">
</p>

- В данном проекте автотесты написаны на языке <code>Java</code> с использованием фреймворка для тестирования Selenide.
- В качестве сборщика был использован - <code>Gradle</code>.
- Использованы фреймворки <code>JUnit 5</code> и [Selenide](https://selenide.org/).
- При прогоне тестов браузер запускается в [Selenoid](https://aerokube.com/selenoid/).
- Для удаленного запуска реализована джоба в <code>Jenkins</code> с формированием Allure-отчета и отправкой результатов в <code>Telegram</code> при помощи бота.
- Осуществлена интеграция с <code>Allure TestOps</code> и <code>Jira</code>

Содержание Allure-отчета:
* Шаги теста;
* Скриншот страницы на последнем шаге;
* Page Source;
* Логи браузерной консоли;
* Видео выполнения автотеста.

## :arrow_forward: Запуск автотестов

### Запуск тестов из терминала
```

```
При выполнении команды, данные тесты запустятся удаленно в <code>Selenoid</code>.

