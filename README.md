## University
Java проект для Матфак ВГУ

### Задачи

#### Бизнес логика:
* Добавление студента
* Удаление студента
* Редактирование студента
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
