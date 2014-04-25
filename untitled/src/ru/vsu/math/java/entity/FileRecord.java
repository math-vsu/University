package ru.vsu.math.java.entity;
import java.io.*;

public abstract class FileRecord implements Savable {
  protected abstract String filename();
  protected abstract String dataToSave();
  protected abstract void buildObject(String[] data);

  public void loadCollection() {
    try {
      RandomAccessFile file = new RandomAccessFile(filename(), "rw");
      long pointer = 0;
      file.seek(pointer);

      while (pointer < file.length()) {
        String dataLine = file.readUTF();
        String[] data = dataLine.split("\\|");
        buildObject(data);
      }
    } catch(EOFException e) {
    } catch(IOException e) {
      e.printStackTrace();
    }
  }

  public void save() {
    File file = new File(filename());

    try {
      RandomAccessFile stream = new RandomAccessFile(file, "rw");

      long lastPosition = stream.length();
      stream.seek(lastPosition);

      stream.writeUTF(dataToSave());
      stream.close();
    } catch(FileNotFoundException e) {
      e.printStackTrace();
    } catch(IOException e) {
      e.printStackTrace();
    }
  }
}
