## University
Java проект для Матфак ВГУ

[Книга по Swing](https://dl.dropboxusercontent.com/u/5884236/%D0%98%D0%B2%D0%B0%D0%BD_%D0%9F%D0%BE%D1%80%D1%82%D1%8F%D0%BD%D0%BA%D0%B8%D0%BD-Swing.%D0%AD%D1%84%D1%84%D0%B5%D0%BA%D1%82%D0%B8%D0%B2%D0%BD%D1%8B%D0%B5_%D0%BF%D0%BE%D0%BB%D1%8C%D0%B7%D0%BE%D0%B2%D0%B0%D1%82%D0%B5%D0%BB%D1%8C%D1%81%D0%BA%D0%B8%D0%B5_%D0%B8%D0%BD%D1%82%D0%B5%D1%80%D1%84%D0%B5%D0%B9%D1%81%D1%8B.pdf)

[Как пользоваться git репозиторием](https://github.com/math-vsu/University/blob/master/doc/git.md)

[JSP and Servlets](https://dl.dropboxusercontent.com/u/5884236/%D0%91%D1%80%D1%8E%D1%81%20%D0%A3.%20%D0%9F%D0%B5%D1%80%D1%80%D0%B8%20-%20Java%20%D1%81%D0%B5%D1%80%D0%B2%D0%BB%D0%B5%D1%82%D1%8B%20%D0%B8%20JSP.%20%D0%A1%D0%B1%D0%BE%D1%80%D0%BD%D0%B8%D0%BA%20%D1%80%D0%B5%D1%86%D0%B5%D0%BF%D1%82%D0%BE%D0%B2.djvu)

[Изначальный гугл-док с планом](https://docs.google.com/document/d/1BMoV-gqheTuWJzDBt9L5pZcKWTOJUtL8zbq6dEZszOE/edit)

### Задачи

#### Бизнес логика:
* ~~Добавление студента~~
* ~~Удаление студента~~
* ~~Рефреш таблицы студентов и списка для удаления~~
* ~~Редактирование студента~~
* ~~JMenu~~
* ~~CRUD преподов~~
* ~~При чтении студента ищем группу по полю Student.group_id, отображаем информацию о группе в списке студентов~~
* ~~В seeder сделать проверку на существование таблицы, если существует - не пытаемся ее создать~~
* [Хранение Group в БД, CRUD(create, update, delete) групп по аналогии со студентами](https://github.com/math-vsu/University/blob/master/doc/groups.md)
* [Чтение списка студентов из файла и загрузка в БД(FileDialog)](https://github.com/math-vsu/University/blob/master/doc/loadFromFile.md)
* При добавлении студента, группы, препода - сразу после добавления получаем его id и отображаем в таблице
* CRUD занятий(пока в самом простом виде: выбираем группу, препода, и пишем время и кабинет)
* Добавить валидации в расписание(нельзя одновременно ставить 2 пары группе, 2 пары в один кабинет, 2 пары у препода)
* Отображение сетки расписания - общей, для группы, для преподавателя
 

#### Рефакторинг:
* Внутри пакета ui создать отдельные подпакеты для разных сущностей, типа ru.vsu.math.java.ui.students; и тд
* в MainUI конструктор монструозен, разбить его на отдельные методы
* Sudent, Group, Tutor, DoubleClass вынести в отдельный пакет, или подпакет в Entity, над названием подумать. Нужно отделить вещественные сущности от абстрактных
* Аналогично отрефакторить конструкторы во всех классах-окнах, разбить на методы чтобы было читабельно
* В нескольких местах происходит операция поиска по коллекции студентов/преподов/групп по id объекта в базе, хорошо бы ввести стуктуру HashMap где ключ - это id в БД, значение - объект из списка в app. Сами хеш-мэпы храним в Application, и делаем методы типа Student.getById(int id), Group.getById(int id), Tutor.getById(int id) а эти методы уже выбирают объект из хеш-мэпа. Соотв при добавлени/удалении объекта изменяем и его хешмеп

#### Архитектура:
* NetworkRecord интерфейс, шлет данные по сети вместо SQL
* Сервер слушает TCP, получает данные и пишет в SQL
* Сервер многопоточный
* Переделать сервер в HTTP веб-сервис
* HttpRecord делает запросы к REST Api
* servlets, java ee, tomcat
* hibernate

#### Доп:
* Попробовать написать тесты на JUnit
