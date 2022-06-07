# alpha
Создать сервис, который обращается к сервису курсов валют, и отдает gif в ответ:<br>
если курс по отношению к рублю за сегодня стал выше вчерашнего, то отдаем рандомную отсюда https://giphy.com/search/rich <br>
если ниже - отсюда https://giphy.com/search/broke <br>
Ссылки<br>
REST API курсов валют - https://docs.openexchangerates.org/ <br>
REST API гифок - https://developers.giphy.com/docs/api#quick-start-guide <br>
Must Have<br>
Сервис на Spring Boot 2 + Java / Kotlin. <br>
Запросы приходят на HTTP endpoint, туда передается код валюты. <br>
Для взаимодействия с внешними сервисами используется Feign. <br>
Все параметры (валюта по отношению к которой смотрится курс, адреса внешних сервисов и т.д.) вынесены в настройки. <br>
На сервис написаны тесты (для мока внешних сервисов можно использовать @mockbean или WireMock). <br>
Для сборки должен использоваться Gradle. <br>
Результатом выполнения должен быть репо на GitHub с инструкцией по запуску.<br>
Nice to Have<br>
Сборка и запуск Docker контейнера с этим сервисом.<br>
Срок выполнения задания - 1 неделя.
# Инструкция по запуску
Docker:<br>
docker build -t alpha . <br>
docker run -p 8080:8080 -t alpha
