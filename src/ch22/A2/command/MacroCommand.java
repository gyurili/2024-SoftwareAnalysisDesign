package ch22.A2.command;

import java.util.ArrayDeque;
import java.util.Deque;

public class MacroCommand implements Command {
    // 명령의 배열 
    private Deque<Command> commands = new ArrayDeque<>();

    // 실행 
    @Override
    public void execute() {
        for (Command cmd: commands) {
            cmd.execute();
        }
    }

    // 추가 
    public void append(Command cmd) {
        if (cmd == this) {
            throw new IllegalArgumentException("infinite loop caused by append");
        }
        commands.push(cmd);
    }

    // 마지막 명령을 삭제
    public void undo() {
        if (!commands.isEmpty()) {
            commands.pop(); // 스택의 맨 위 객체 제거
        }
    }

    // 전부 삭제 
    public void clear() {
        commands.clear();
    }
}
