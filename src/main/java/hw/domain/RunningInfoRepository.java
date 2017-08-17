package hw.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RunningInfoRepository extends JpaRepository<RunningInformation, String>{

    Page<RunningInformation> findAll(Pageable pageable);


}
