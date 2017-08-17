package hw.service;

import hw.domain.RunningInformation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AnalysisService {

    List<RunningInformation> saveRunningInfo(List<RunningInformation> runningInformation);

    Page<RunningInformation> findAll(Pageable pageable);

    void deleteByRunningId(String runningId);
}
