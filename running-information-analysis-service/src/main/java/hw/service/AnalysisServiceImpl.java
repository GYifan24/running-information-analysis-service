package hw.service;

import hw.domain.RunningInfoRepository;
import hw.domain.RunningInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnalysisServiceImpl implements AnalysisService {

    @Autowired
    private RunningInfoRepository runningInfoRepository;

    @Override
    public List<RunningInformation> saveRunningInfo(List<RunningInformation> runningInformation) {
        for(RunningInformation info : runningInformation){
            int heartRate = 60 + (int)(Math.random() * 140);
            info.setHeartRate(heartRate);
            if(heartRate <= 75)
                info.setHealthWarningLevel("LOW");
            else if (heartRate <= 120)
                info.setHealthWarningLevel("NORMAL");
            else
                info.setHealthWarningLevel("HIGH");
        }
        return runningInfoRepository.save(runningInformation);
    }

    @Override
    public Page<RunningInformation> findAll(Pageable pageable) {
        return runningInfoRepository.findAll(pageable);
    }

    @Override
    public void deleteByRunningId(String runningId) {
        runningInfoRepository.delete(runningId);
    }
}
