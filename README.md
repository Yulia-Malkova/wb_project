<p align="center">
<a href="https://www.wildberries.ru/"> <img width=50%" src="src/media/wildberries-logo.png"> </a></h1>
<p align="center">

# <p align="center"> Проект по автоматизации тестовых сценариев для  Wildberries <p align="center">
## ![##BC13A2](https://placehold.co/15x15/BC13A2/BC13A2.png) Содержание:

- [Использованный стек технологий](#computer-использованный-стек-технологий)
- [Запуск тестов из терминала](#arrow_forward-запуск-тестов-из-терминала)
- [Сборка в Jenkins](#сборка-в-jenkins)
- [Пример Allure-отчета](#пример-allure-отчета)
- [Уведомления в Telegram с использованием бота](#уведомления-в-telegram-с-использованием-бота)
- [Видео примера запуска тестов в Selenoid](#-видео-примера-запуска-теста-в-selenoid)

## ![##BC13A2](https://placehold.co/15x15/BC13A2/BC13A2.png) Использованный стек технологий
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

## ![##BC13A2](https://placehold.co/15x15/BC13A2/BC13A2.png) Запуск автотестов

### Запуск тестов из терминала
Для запуска можно выбрать один из трех тест-сьютов:

```mermaid
flowchart LR
node1([Test Suites]) --> node2([Запуск всех тестов]) --> node3([test])
node1([Test Suites]) --> node4([Запуск тестов, связанных с корзиной]) --> node5([basket])
node1([Test Suites]) --> node6([Запуск тестов, связанных с каталогом]) --> node7([catalog])
```
Команда для запуска тестов из терминала:
```
gradle clean ${TEST_JOB}
```
При необходимости также можно переопределить параметры запуска

```
gradle clean
${TEST_JOB}
-Dbrowser=${BROWSER}
-Dversion=${BROWSER_VERSION}
 -DbrowserSize=${BROWSER_SIZE}
 -DwebDriver=${WEB_DRIVER}
```
При выполнении команды, тесты запустятся удаленно в <code>Selenoid</code>.

### Параметры сборки

* <code>TEST_JOB</code> – тестовый сьют.
* <code>BROWSER_NAME</code> – браузер, в котором будут выполняться тесты. По умолчанию - <code>chrome</code>.
* <code>BROWSER_VERSION</code> – версия браузера, в которой будут выполняться тесты. По умолчанию - <code>100.0</code>.
* <code>BROWSER_SIZE</code> – размер окна браузера, в котором будут выполняться тесты. По умолчанию - <code>1920x1080</code>.
* <code>WEB_DRIVER</code> – адрес удаленного сервера, на котором будут запускаться тесты. По умолчанию - <code>https://user1:1234@selenoid.autotests.cloud/</code>.
ç Сборка в Jenkins
<p align="center">
<img title="Jenkins Build" src="src/media/ jenkins.png">
</p>

## ![##BC13A2](https://placehold.co/15x15/BC13A2/BC13A2.png) Пример Allure-отчета
### Overview

<p align="center">
<img title="Allure Overview" src="src/media/allure-overview.png">
</p>
### Результат выполнения теста

<p align="center">
<img title="Test Results in Alure" src="src/media/allure_test_result.png">
</p>

## ![##BC13A2](https://placehold.co/15x15/BC13A2/BC13A2.png) Интеграция с Allure TestOps

Выполнена интеграция сборки <code>Jenkins</code> с <code>Allure TestOps</code>.
Результат выполнения автотестов отображается в <code>Allure TestOps</code>
На Dashboard в <code>Allure TestOps</code> отображена статистика пройденных тестов.

<p align="center">
<img title="Allure TestOps DashBoard" src="src/media/allure_test_ops.png">
</p>

## ![##BC13A2](https://placehold.co/15x15/BC13A2/BC13A2.png) Интеграция с Jira

Реализована интеграция <code>Allure TestOps</code> с <code>Jira</code>, в тикете отображается информация, какие тест-кейсы были написаны в рамках задачи и результат их прогона.

<p align="center">
<img title="Jira Task" src="src/media/jira_integration.png">
</p>

## ![##BC13A2](https://placehold.co/15x15/BC13A2/BC13A2.png) Уведомления в Telegram с использованием бота

После завершения сборки, бот созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с результатом.

<p align="center">
<img width="70%" title="Telegram Notifications" src="src/media/telegram_bot.png">
</p>

## ![##BC13A2](https://placehold.co/15x15/BC13A2/BC13A2.png) Видео примера запуска тестов в Selenoid

К каждому тесту в отчете прилагается видео прогона.
<p align="center">
  <img title="Selenoid Video" src="src/media/video_test.gif">
</p>
