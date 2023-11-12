<p align="center">
<a href="https://www.wildberries.ru/"> <img width=50%" src="media/wildberries-logo.png"> </a></h1>
<p align="center">

# <p align="center"> Проект по автоматизации тестовых сценариев для  Wildberries <p align="center">

## ![##BC13A2](https://placehold.co/15x15/BC13A2/BC13A2.png) Использованный стек технологий
<p align="center">
<a href="https://www.jetbrains.com/idea/"><img width="6%" title="IntelliJ IDEA" src="media/Intelij_IDEA.svg">
<a href="https://www.java.com/"><img width="6%" title="Java" src="media/Java.svg">
<a href="https://selenide.org/"><img width="6%" title="Selenide" src="media/Selenide.svg">
<a href="https://aerokube.com/selenoid/latest/"><img width="6%" title="Selenoid" src="media/Selenoid.svg">
<a href="https://github.com/allure-framework"><img width="6%" title="Allure Report" src="media/Allure_Report.svg">
<a href="https://qameta.io/"><img width="5%" title="Allure TestOps" src="media/AllureTestOps.svg">
<a href="https://gradle.org/"><img width="6%" title="Gradle" src="media/Gradle.svg">
<a href="https://junit.org/junit5/"><img width="6%" title="JUnit5" src="media/JUnit5.svg">
<a href="https://github.com/"><img width="6%" title="GitHub" src="media/GitHub.svg">
<a href="https://www.jenkins.io/"><img width="6%" title="Jenkins" src="media/Jenkins.svg">
<a href="https://web.telegram.org/"><img width="6%" title="Telegram" src="media/Telegram.svg">
<a href="https://www.atlassian.com/software/jira/"><img width="5%" title="Jira" src="media/Jira.svg">
</p>

- В данном проекте автотесты написаны на языке <code>Java</code> с использованием фреймворка для тестирования Selenide.
- В качестве сборщика был использован - <code>Gradle</code>.
- Использованы фреймворки <code>JUnit 5</code> и [Selenide](https://selenide.org/).
- При прогоне тестов браузер запускается в [Selenoid](https://aerokube.com/selenoid/).
- Для удаленного запуска реализована джоба в Jenkins с формированием Allure-отчета и отправкой результатов в <code>Telegram</code> при помощи бота.
- Осуществлена интеграция с <code>Allure TestOps </code> и <code>Jira</code>.

Содержание Allure-отчета:
* Шаги теста;
* Скриншот страницы на последнем шаге;
* Page Source;
* Логи браузерной консоли;
* Видео выполнения автотеста.

## ![##BC13A2](https://placehold.co/15x15/BC13A2/BC13A2.png) Запуск автотестов

### Запуск тестов из терминала

Команда для запуска всех тестов из терминала:
```
gradle clean test
```
При выполнении команды тесты запустятся удаленно в <code>Selenoid</code>.

Для запуска можно выбрать один из трех тест-сьютов:

```mermaid
flowchart LR
node1([Test Suites]) --> node2([Запуск всех тестов]) --> node3([test])
node1([Test Suites]) --> node4([Запуск тестов, связанных с корзиной]) --> node5([basket])
node1([Test Suites]) --> node6([Запуск тестов, связанных с каталогом]) --> node7([catalog])
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
### Параметры сборки

* <code>TEST_JOB</code> – тестовый сьют.
* <code>BROWSER_NAME</code> – браузер, в котором будут выполняться тесты. По умолчанию - <code>chrome</code>.
* <code>BROWSER_VERSION</code> – версия браузера, в которой будут выполняться тесты. По умолчанию - <code>100.0</code>.
* <code>BROWSER_SIZE</code> – размер окна браузера, в котором будут выполняться тесты. По умолчанию - <code>1920x1080</code>.
* <code>WEB_DRIVER</code> – адрес удаленного сервера, на котором будут запускаться тесты.

## ![##BC13A2](https://placehold.co/15x15/BC13A2/BC13A2.png) Сборка в [Jenkins](https://jenkins.autotests.cloud/job/021-Yulia_Malkova-WB_project/)
<p align="center">
<img title="Jenkins Build" src="media/ jenkins.png">
</p>

## ![##BC13A2](https://placehold.co/15x15/BC13A2/BC13A2.png) Пример [Allure-отчета](https://jenkins.autotests.cloud/job/021-Yulia_Malkova-WB_project/allure/)
### Overview

<p align="center">
<img title="Allure Overview" src="media/allure-overview.png">
</p>

### Результат выполнения теста

<p align="center">
<img title="Test Results in Alure" src="media/allure_test_result.png">
</p>

## ![##BC13A2](https://placehold.co/15x15/BC13A2/BC13A2.png) Интеграция с [Allure TestOps](https://allure.autotests.cloud/project/3682/dashboards)

Выполнена интеграция сборки <code>Jenkins</code> с <code>Allure TestOps</code>.
Результат выполнения автотестов отображается в <code>Allure TestOps</code>
На Dashboard в <code>Allure TestOps</code> отображена статистика пройденных тестов.

<p align="center">
<img title="Allure TestOps DashBoard" src="media/allure_test_ops.png">
</p>

## ![##BC13A2](https://placehold.co/15x15/BC13A2/BC13A2.png) Интеграция с [Jira](https://jira.autotests.cloud/browse/HOMEWORK-893)

Реализована интеграция <code>Allure TestOps</code> с <code>Jira</code>, в тикете отображается информация, какие тест-кейсы были написаны в рамках задачи и результат их прогона.

<p align="center">
<img title="Jira Task" src="media/jira_integration.png">
</p>

## ![##BC13A2](https://placehold.co/15x15/BC13A2/BC13A2.png) Уведомления в Telegram с использованием бота

После завершения сборки, бот созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с результатом.

<p align="center">
<img width="70%" title="Telegram Notifications" src="media/telegram_bot.png">
</p>

## ![##BC13A2](https://placehold.co/15x15/BC13A2/BC13A2.png) Видео примера запуска тестов в Selenoid

К каждому тесту в отчете прилагается видео прогона.
<p align="center">
  <img title="Selenoid Video" src="media/video_test.gif">
</p>
