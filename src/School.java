import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Consumer;

public class School implements Iterable<Student> {
    private List<Student> studentList;

    public School(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public Iterator<Student> iterator(){
        return new Iterator<Student>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                if(index == (studentList.size()-1)){
                    return false;
                }
                return true;
            }

            @Override
            public Student next() {
                index++;
                return studentList.get(index);
            }
        };
    }

}
