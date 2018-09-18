package org.computerized.pl.code;

public final class CodeDefinition {
    public static enum Auth {
        STUDENT(0),
        WORKER(1),
        LECTURER(2),
        ADMIN(3);

        private final Integer code;

        Auth(Integer code) {
            this.code = code;
        }

        public Integer getCode() {
            return code;
        }
    }
}
