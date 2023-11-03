package algorithm;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Serialization {
	public void Serializer(ObjectCluster cluster, String fileName) {
		File file = new File(fileName);
		try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
			objectOutputStream.writeObject(cluster);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public ObjectCluster Deserializer(String fileName) {
		File file = new File(fileName);
		ObjectCluster objectCluster;
		try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
			objectCluster = (ObjectCluster) objectInputStream.readObject();
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}

		return objectCluster;
	}
}

class ObjectCluster implements Serializable{
	List<Object> objectList = new ArrayList<>();

	public boolean addObject(Object o) {
		return objectList.add(o);
	}

	public List<Object> getObjectList() {
		return objectList;
	}
}

class MyClass implements Serializable {
	private String name;

	public MyClass(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
}