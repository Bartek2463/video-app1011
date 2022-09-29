package pl.szybiak.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.szybiak.model.VideoCassette;

@Repository
public interface VideoAssettsRepository extends CrudRepository<VideoCassette,Long> {


}
