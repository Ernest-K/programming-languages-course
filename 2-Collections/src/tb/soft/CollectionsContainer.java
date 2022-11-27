package tb.soft;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class CollectionsContainer<T> {
    private final Set<T> hashSet;
    private final Set<T> treeSet;

    private final List<T> arrayList;
    private final List<T> linkedList;

    private final Map<T, Integer> hashMap;
    private final Map<T, Integer> treeMap;


    public CollectionsContainer() {
        this.hashSet = new HashSet<>();
        this.treeSet = new TreeSet<>();
        this.arrayList = new ArrayList<>();
        this.linkedList = new LinkedList<>();
        this.hashMap = new HashMap<>();
        this.treeMap = new TreeMap<>();
    }

    void add(T object){
        this.hashSet.add(object);
        this.treeSet.add(object);
        this.arrayList.add(object);
        this.linkedList.add(object);
        this.hashMap.put(object, hashMap.size()+1);
        this.treeMap.put(object, treeMap.size()+1);
    }

    void remove(T object){
        this.hashSet.remove(object);
        this.treeSet.remove(object);
        this.arrayList.remove(object);
        this.linkedList.remove(object);
    }

    public Set<T> getHashSet() {
        return hashSet;
    }

    public Set<T> getTreeSet() {
        return (Set<T>) treeSet;
    }

    public List<T> getArrayList() {
        return arrayList;
    }

    public List<T> getLinkedList() {
        return linkedList;
    }

    public Map<T, Integer> getHashMap() {
        return hashMap;
    }

    public Map<T, Integer> getTreeMap() {
        return treeMap;
    }

    public static void printToFile(String fileName, CollectionsContainer<? extends Person> collectionsContainer){
        String separator = ",";
        try{
            PrintWriter writer = new PrintWriter(fileName);
            writer.print("HashSet:"+separator);
            writer.print(printCollection(collectionsContainer.getHashSet()));
            writer.print("TreeSet:"+separator);
            writer.print(printCollection(collectionsContainer.getTreeSet()));
            writer.print("ArrayList:"+separator);
            writer.print(printCollection(collectionsContainer.getArrayList()));
            writer.print("LinkedList:"+separator);
            writer.print(printCollection(collectionsContainer.getLinkedList()));
            writer.print("HashMap:"+separator);
            writer.print(printCollection(collectionsContainer.getHashMap()));
            writer.print("TreeMap:"+separator);
            writer.print(printCollection(collectionsContainer.getTreeMap()));
            writer.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static String printCollection(Collection<? extends Person> collection){
        StringBuilder line = new StringBuilder();
        for (Person p: collection){
            line.append(p.getFirstName()).append(" ");
            line.append(p.getLastName()).append(" ");
            line.append(p.getBirthYear()).append(" ");
            line.append(p.getJob().toString()).append(",");
        }
        line.append("\n");
        return line.toString();
    }

    private static String printCollection(Map<? extends Person, Integer> map){
        StringBuilder line = new StringBuilder();
        for (Person p: map.keySet()){
            line.append(p.getFirstName()).append(" ");
            line.append(p.getLastName()).append(" ");
            line.append(p.getBirthYear()).append(" ");
            line.append(p.getJob().toString()).append(",");
        }
        line.append("\n");
        return line.toString();
    }
}
