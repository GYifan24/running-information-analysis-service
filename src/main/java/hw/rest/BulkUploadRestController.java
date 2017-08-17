package hw.rest;

import hw.domain.RunningInformation;
import hw.service.AnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BulkUploadRestController {

    @Autowired
    private AnalysisService analysisService;

    @RequestMapping(value = "/analysis", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(@RequestBody List<RunningInformation> runningInformation){
        this.analysisService.saveRunningInfo(runningInformation);
    }

    @RequestMapping(value = "purge/{runningId}", method = RequestMethod.DELETE)
    public void deleteByRunningId(@PathVariable String runningId){
        this.analysisService.deleteByRunningId(runningId);
    }

    @RequestMapping(value = "analysis/result", method = RequestMethod.GET)
    public Page<RunningInformation> findAll(@RequestParam int page){
        int size = 2;
        return this.analysisService.findAll(new PageRequest(page, size, Sort.Direction.DESC, "heartRate"));
    }
}
