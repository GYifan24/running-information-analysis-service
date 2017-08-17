package hw.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Table(name = "RUNNING_ANALYSIS")
@Entity
public class RunningInformation {
    @Id
    private String runningId;

    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    @JsonIgnore
    private String latitude;
    @JsonIgnore
    private String longitude;
    @JsonIgnore
    private String runningDistance;

    private String totalRunningTime;
    private int heartRate = 0;
    @JsonIgnore
    private Date timestamp = new Date();
    private String healthWarningLevel;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "username", column = @Column(name = "userName")),
            @AttributeOverride(name = "address", column = @Column(name = "userAddress"))
    })
    private UserInfo userInfo;

    @JsonCreator
    public RunningInformation(){
    }

//    public RunningInformation(UserInfo userInfo){
//        this.userInfo = userInfo;
//    }

}
