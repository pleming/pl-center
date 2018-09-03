package org.computerized.pl.code;

public final class CodeDefinition {
    public static enum Auth {
        STUDENT(0),
        WORKER(1),
        ASSISTANT(2),
        PROF(3),
        ADMIN(4);

        private final Integer code;

        Auth(Integer code) {
            this.code = code;
        }

        public Integer getCode() {
            return code;
        }
    }
}
