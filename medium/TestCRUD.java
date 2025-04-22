package medium;

public class TestCRUD {
    public static void main(String[] args) {
        StudentDao dao = new StudentDao();

        Student s1 = new Student("Teesha", 22);
        dao.saveStudent(s1);
        System.out.println("Student saved: " + s1);

        Student fetched = dao.getStudent(s1.getId());
        System.out.println("Student fetched: " + fetched);

        fetched.setAge(23);
        dao.updateStudent(fetched);
        System.out.println("Student updated: " + fetched);

        dao.deleteStudent(fetched.getId());
        System.out.println("Student deleted with ID: " + fetched.getId());
    }
}
