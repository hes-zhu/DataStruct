package Array;

public class Student {

    private String name;
    private int score;

    public Student(String studentName, int studentScore) {
        this.name = studentName;
        this.score = studentScore;
    }

    @Override
    public String toString() {
        return String.format("Student(name: %s, score: %d)", name, score);
    }

    public static void main(String[] args) {
        EArray<Student> arr = new EArray<Student>();
        arr.addLast(new Student("snn", 100));
        arr.addLast(new Student("hq", 999));
        arr.addLast(new Student("ghy", 333));
        System.out.println(arr);
    }
}
