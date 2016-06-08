/**
 * Метод hashCode должен работать следующим образом:
 * если uuid равно null - возвращает 0;
 * если uuid пустая строка - возвращает 0;
 * в других случаях нужно суммировать все characters в uuid
 * (напомню из курса 101, что тип char - это не более чем число ;) ) и возвращать сумму.
 * Что касается класса Session, то в его случае мы должны в качестве hashCode возвращать
 * результат работы метода hashCode у поля date.
 */

package exercises.overridingHashCode;

import java.util.List;
import java.util.Date;

public class Course {

    private final String uuid;

    private final String name;

    private final List<Session> sessions;

    public Course(final String uuid, final String name, final List<Session> sessions) {
        this.uuid = uuid;
        this.name = name;
        this.sessions = sessions;
    }

    public String getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    @Override
    public boolean equals(final Object object) {
        if (!(object instanceof Course))
            return false;

        final Course that = (Course) object;
        if (!that.getUuid().equals(this.getUuid()))
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        if (getUuid() == null || getUuid() == "") {
            return 0;
        } else {
            int result = 0;
            final String uuid = getUuid();
            for (int i = 0; i < uuid.length(); i++) {
                result += uuid.charAt(i);
            }
            return result;
        }
    }

    public class Session {

        private final Date startDate;

        public Session(final Date startDate) {
            this.startDate = startDate;
        }

        public Date getStartDate() {
            return this.startDate;
        }

        public Course getCourse() {
            return Course.this;
        }

        @Override
        public boolean equals(final Object object) {
            if (!(object instanceof Session)) return false;

            final Session that = (Session) object;
            if (!that.getStartDate().equals(this.getStartDate())) return false;

            if (!that.getCourse().equals(this.getCourse())) return false;

            return true;
        }

        @Override
        public int hashCode() {
            return startDate.hashCode();
        }

    }

}

