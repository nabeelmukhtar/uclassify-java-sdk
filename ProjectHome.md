This project provides a Java wrapper for uClassify API.

Example Usage:
```
final UClassifyClientFactory factory = UClassifyClientFactory.newInstance(readKeyValue, null);
final UClassifyClient client = factory.createUClassifyClient();
List<ClassInformation> informations = client.getInformation("uClassify", "Topics");
System.out.println("===================== Classifier Info ========================");
System.out.println("Class Name:Total Count:Unique Features");
for (ClassInformation classInformation : informations) {
	System.out.println(classInformation.getClassName() + ":" + classInformation.getTotalCount() + ":" + classInformation.getUniqueFeatures());
}
Map<String, Classification> classifications = client.classify("uClassify", "Topics", Arrays.asList("I am working on hadoop."));
System.out.println("================ Classifications ==================");
for(String text : classifications.keySet()) {
	Classification classification = classifications.get(text);
	System.out.println(text);
	System.out.println("====================");
	for (Class clazz : classification.getClazz()) {
		System.out.println(clazz.getClassName() + ":" + clazz.getP());
	}
}
```

&lt;wiki:gadget url="http://www.ohloh.net/accounts/118615/widgets/account\_detailed.xml" height="55" border="0"/&gt;