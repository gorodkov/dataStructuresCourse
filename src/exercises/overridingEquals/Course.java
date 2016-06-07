/**
 * Была у нас программа, которая показывала предстоящие курсы университета на телефоне.
 * Эта программа, само собой, имела модельки:
 * Course - описывает курс, имя, картинку, преподавателя и т.д.;
 * Course.Session - описывает одну сессию курса (например курс Дискретной математики в 2015 году).
 * Вам предстоит реализовать метод сравнения, который бы удовлетворял следующим критериям:
 * единственное, что нам важно для курса при сравнении это uuid курса;
 * с сервера может прийти обновленное имя, обложка, что угодно другое и единственное как мы можем
 * сравнить курс с сервера с курсом в локальной БД это его uuid;
 * для сессии сравнение немного сложнее - мы должны сравнивать дату начала сессии и курс,
 * к которому привязана сессия; только если оба эти значения одинаковы мы будем считать,
 * что сессии также одинаковы.
*/

package exercises.overridingEquals;

import java.util.List;
import java.util.Date;

public class Course {

    private final Long uuid;

    private final String name;

    private final List<Session> sessions;

    public Course(final Long uuid, final String name, final List<Session> sessions) {
        this.uuid = uuid;
        this.name = name;
        this.sessions = sessions;
    }

    public Long getUuid() {
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
        if (!(object instanceof Course)) {
            return  false;
        }
        final Course other = (Course) object;

        if (other.uuid.equals(this.uuid)) {
            return true;
        } else {
            return  false;
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
            if (!(object instanceof Course.Session)) {
                return  false;
            }
            final Course.Session otherSession = (Course.Session) object;

            if (otherSession.getStartDate().equals(this.getStartDate()) && Course.super.equals(otherSession.getCourse())) {
                return true;
            } else {
                return  false;
            }
        }

    }

}

