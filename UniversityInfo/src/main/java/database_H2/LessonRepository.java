package database_H2;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface LessonRepository extends CrudRepository<Lesson, Integer> {

}