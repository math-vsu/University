### Группы
#### Done
* ~~Окно добавления группы, 3 поля: курс, группа и подгруппа~~
* ~~Делаем также Group extends SQLRecord, по аналогии все абстрактные метода которые понадобятся в запросах к БД~~
* ~~Окно просмотра списка групп(пока самое простое, все вместе), удаление и редактирование группы~~
* ~~Добавляем в Student поле groupId, добавляем его в БД, тип Integer~~
* ~~fetchGroup вызывает Group.find(id) статический метод, реализуем в SQLRecord.~~
* ~~При загрузке студентов loadCollection -> buildObject получаем объект группы и передаем в конструктор студента~~
* ~~В списке студентов вместо TODO отображаем название группы~~
* ~~В редактировании студента добавляем возможность редактирования его группы - селект со списком всех групп~~

#### TODO
* ~~поля магистр/бакалавр, специалист~~
* ~~Добавляем класс GroupLoader.getGroups(degree, course), в который передаем в зависимости от выбранного пункта Бак/Маг и курс.~~ 
* Выбираем из БД, создаем новое окно просмотра групп и передаем в него коллекцию выбранных групп

```
  class GroupsLoader {
    public static List<Group> getGroupStudents(degree, course, group) {
      Group group = Group.findGroup(degree, course, group);
      List<Student> groupStudents = group.students();
      return groupStudents;
    }
  }
  
  class Group {
    ...
    public static Group findGroup(degree, course, group) {
      ResultSet rs = findBy("group_num=" + group + " AND course=" + course + " AND degree=" + degree);
      // как в buildObject получаем из rs значения столбцов и по ним создаем группу
      Group group = new Group(параметры)
      return groupl
    }
    
    public List<Student> students() {
      ResultSet rs = findBy("group_id=" + this.id());
      // проходим по result set и делаем что угодно с данными
      // лучше всего - брать id студента и находить его в нашей коллекции app.studentsList
      // и добавлять в какую-нибудь новую коллекцию типа List<Student> students
      return students;
    }
    ...
  }
  
  class SQLRecord {
    public findBy(String conditions) {
      // создаем коннект для нового запроса
      ResultSet rs = "SELECT * FROM table_name " + conditions;
    }
  }
  
  в MainUI на каждый из пунктов меню ведущих на группу - навешиваем обработчик типа
  
  class GroupMenuItem extends JMenuItem {
  
    public GroupMenuItem(String title, group_num, course, degree) {
      // сохраняем параметры группы во внутрених полях, делаем им публичные геттеры и сеттеры
      super(title);
    }
  }
  
  someGroupItem.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
      // degree, course, group_num получаем через геттеры объекта, на котром произошел клик
      // надо почитать в гугле/книгах, как получить объект на который кликнули
      // скорее всего это можно сделать через объект ActionEvent e
      List<Student> students = GroupLoader.getGroups(degree, course, group_num);
      // создаем новое окно группы, передаем в него список студентов, отображаем
    }
  });
  
  class MainUI {
  
    public MainUI(Application app) {
      ...
      // создаем список пукнтов меню соотв группам
      // он нужен, чтобы в дальнейшем, когда мы удалим группу - можно было по нему перестроить меню
      List<GroupMenuItem> groupMenuItems = new List<GroupMenuItem>();
      // берем список групп из app.groupsList();
      // Проходим по нему, для каждой группы создаем GroupMenuItem и добавляем в соответствующий пункт меню
      // т.о. пункты меню магистр/специалист, 1-6 курсы создаем уже заранее, и после этого создаем меню групп
    }
  
  }

  TODO: дописать случай когда удалили группу, и соотв нужно удалить ее из меню
  по факту просто удаляем item из списка, как-то очищаем пункты меню "1-6 курс" и заново распихиваем по ним itemы из списка
  
```
