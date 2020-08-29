package exam.answerSheetContext.userInterface;

import exam.answerSheetContext.application.AnswerSheetApplicationService;
import exam.answerSheetContext.application.AssignAnswerSheetCommand;
import exam.answerSheetContext.application.SubmitAnswerSheetCommand;
import exam.answerSheetContext.domain.model.sheet.AnswerSheetId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class AnswerSheetController {

    private final AnswerSheetApplicationService answerSheetApplicationService;

    @Autowired
    public AnswerSheetController(AnswerSheetApplicationService answerSheetApplicationService) {
        this.answerSheetApplicationService = answerSheetApplicationService;
    }

    @PostMapping("/answerSheet")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    AnswerSheetDTO assign(@RequestBody AssignAnswerSheetCommand command) {
        final AnswerSheetId answerSheetId = answerSheetApplicationService.assignAnswerSheet(command);
        return AnswerSheetDTO.from(answerSheetId);
    }

    @PutMapping("/answerSheet/{answerSheetId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void submit(@PathVariable String answerSheetId, @RequestBody SubmitAnswerSheetCommand command) {
        answerSheetApplicationService.submitAnswerSheet(answerSheetId, command);
    }
}
