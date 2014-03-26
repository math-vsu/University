## University
Java проект для Матфак ВГУ

[Книга по Swing](https://dl.dropboxusercontent.com/u/5884236/%D0%98%D0%B2%D0%B0%D0%BD_%D0%9F%D0%BE%D1%80%D1%82%D1%8F%D0%BD%D0%BA%D0%B8%D0%BD-Swing.%D0%AD%D1%84%D1%84%D0%B5%D0%BA%D1%82%D0%B8%D0%B2%D0%BD%D1%8B%D0%B5_%D0%BF%D0%BE%D0%BB%D1%8C%D0%B7%D0%BE%D0%B2%D0%B0%D1%82%D0%B5%D0%BB%D1%8C%D1%81%D0%BA%D0%B8%D0%B5_%D0%B8%D0%BD%D1%82%D0%B5%D1%80%D1%84%D0%B5%D0%B9%D1%81%D1%8B.pdf)

### Задачи

#### Бизнес логика:
* ~~Добавление студента~~
* ~~Удаление студента~~
* ~~Рефреш таблицы студентов и списка для удаления~~
* [Редактирование студента]()
* Хранение Group в БД
* CRUD(create, update, delete) групп по аналогии со студентами
* При чтении студента ищем группу по полю Student.group_id, отображаем информацию о группе в списке студентов
* Диалог просмотра отдельной группы(список студентов группы)
* В seeder сделать проверку на существование таблицы, если существует - не пытаемся ее создать
* При добавлении студента - сразу после добавления получаем его id и отображаем в таблице
* CRUD преподов
* CRUD занятий(пока в самом простом виде: выбираем группу, препода, и пишем время и кабинет)
* Добавить валидации в расписание(нельзя одновременно ставить 2 пары группе, 2 пары в один кабинет, 2 пары у препода)

#### Архитектура:
* NetworkRecord интерфейс, шлет данные по сети вместо SQL
* Сервер слушает TCP, получает данные и пишет в SQL
* Сервер многопоточный
* Переделать сервер в HTTP веб-сервис
* HttpRecord делает запросы к REST Api
* servlets, java ee, tomcat
* hibernate
