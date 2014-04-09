### Загрузка данных из файлов

* Изучаем и навешиваем компонент [JFileChooser](http://docs.oracle.com/javase/tutorial/uiswing/components/filechooser.html) на соответствующие пункты меню
* Создаем класс FileLoader
* Наследуем от него StudentFileLoader, GroupFileLoader и TutorFileLoader
* В FileLoader метод readAndCreateObjects(String filename), абстрактный метод buildObject()
* Берем код из FileRecord, читающий файлы кидаем его в FileLoader.readAndCreateObjects()

```      
      RandomAccessFile file = new RandomAccessFile(filename, "rw");
      long pointer = 0;
      file.seek(pointer);

      while (pointer < file.length()) {
        String dataLine = file.readUTF();
        String[] data = dataLine.split("\\,");
        buildObject(data);
      }
```

* В дочерних классах реализуем абстрактный метод buildObject
* В StudentFileLoader.buildObject в качестве одного из полученных значений будет id группы, по id получаем сам объект группы и создаем объект студента
* В GroupFileLoader и TutorFileLoader ничего особенного, просто создаем объекты с переданными полями
* Может произойти, что в файле студентов есть студент с id группы, которой не существует. В этом случае нужно бросить исключение, и где-то выше обработать его, выведя сообщение что файл некорректен
