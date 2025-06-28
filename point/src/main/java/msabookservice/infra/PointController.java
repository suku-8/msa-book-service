package msabookservice.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import msabookservice.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/points")
@Transactional
public class PointController {

    @Autowired
    PointRepository pointRepository;

    @RequestMapping(
    value = "/points/{id}/authktuser",
    method = RequestMethod.PUT,
    produces = "application/json;charset=UTF-8"
    )
    public Point authKtUser(
        @PathVariable(value = "id") Long id,
        @RequestBody AuthKtUserCommand command // 1. 요청 데이터를 Command 객체로 받도록 변경
    ) throws Exception {
        System.out.println("##### /point/authKtUser  called #####");
        Optional<Point> optionalPoint = pointRepository.findById(id);

        optionalPoint.orElseThrow(() -> new Exception("No Entity Found"));
        Point point = optionalPoint.get();
        
        // 2. Aggregate의 authKtUser 메서드에 Command로 받은 isKt 값을 전달
        point.authKtUser(command.getIsKt());

        pointRepository.save(point);
        return point;
    }

    @RequestMapping(
    value = "/points/{id}/addpoint",
    method = RequestMethod.PUT,
    produces = "application/json;charset=UTF-8"
    )
    public Point addPoint(
        @PathVariable(value = "id") Long id,
        @RequestBody AddPointCommand command // 1. 요청 데이터를 Command 객체로 받도록 변경
    ) throws Exception {
        System.out.println("##### /point/addPoint  called #####");
        Optional<Point> optionalPoint = pointRepository.findById(id);

        optionalPoint.orElseThrow(() -> new Exception("No Entity Found"));
        Point point = optionalPoint.get();

        // 2. Aggregate의 addPoint 메서드에 Command로 받은 amount 값을 전달
        point.addPoint(command.getAmount());

        pointRepository.save(point);
        return point;
    }


}
//>>> Clean Arch / Inbound Adaptor

