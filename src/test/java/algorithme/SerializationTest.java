package algorithme;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SerializationTest {
	@Test
	public void should_serializer_deserializer_return_right_object(){
		ObjectCluster objectCluster = new ObjectCluster();

		MyClass myClass1 = new MyClass("111111");
		MyClass myClass2 = new MyClass("222222");
		MyClass myClass3 = new MyClass("333333");

		objectCluster.addObject(myClass1);
		objectCluster.addObject(myClass2);
		objectCluster.addObject(myClass3);

		String filePath = "C:\\Users\\toysoldier\\Documents\\IdeaProject\\preparation-entretien-sfeir\\src\\main" +
				"\\resources\\testSerialization.txt";

		Serialization serialization = new Serialization();
		serialization.Serializer(objectCluster, filePath);
		ObjectCluster newObjectCluster =  serialization.Deserializer(filePath);

		assertEquals("111111", ((MyClass)newObjectCluster.getObjectList().get(0)).getName());
		assertEquals("222222", ((MyClass)newObjectCluster.getObjectList().get(1)).getName());
		assertEquals("333333", ((MyClass)newObjectCluster.getObjectList().get(2)).getName());


	}
}
