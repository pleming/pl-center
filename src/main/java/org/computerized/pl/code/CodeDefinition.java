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

    public static enum SidebarPath {
        STUDENT("/resources/jsp/student/sidebar.jsp"),
        WORKER("/resources/jsp/worker/sidebar.jsp"),
        LECTURER("/resources/jsp/lecturer/sidebar.jsp"),
        ADMIN("/resources/jsp/admin/sidebar.jsp");

        private final String path;

        SidebarPath(String path) {
            this.path = path;
        }

        public String getPath() {
            return path;
        }
    }
}
