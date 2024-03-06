package studio.thinkground.testproject.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
public class MemberDTO {
    @Setter
    private String name;
    @Setter
    private String email;
    @Setter
    private String organization;

    @Override
    public String toString(){
        return "MemeberDTO[" + this.name +
                ", " + this.email + ", " + this.organization + "]";
    }
}
