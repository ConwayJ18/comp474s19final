# comp474s19final
This repo contains code for the final project of COMP 474, offered by Loyola University Chicago in Spring 2019. The code belongs to Jess Conway, Anjali Shah, Cong Wang, and Yuyang Zhao.

---
# Requirements Documentation
## Functional Requirements (F.X)
*The Application Interface (F.1.X)*
  1. The application should be operated via a graphical user interface (GUI)
  2. The interface shall have a timer that counts up
  3. The interface shall have two separate and independently incremented score counters
  4. The interface shall deliver notifications when certain conditions are met

*The Timer (F.2.X)*
  1. The timer shall record time in the format HH:MM:SS, where MM & SS are always <=59
  2. HH, MM, SS shall always display integer values >=0
  3. HH, MM, SS shall always display two-digit values, with leading zeroes as necessary
  4. The timer shall be set to 00:00:00 on startup
  5. The timer shall allow HH values <=99
  6. If the timer does reach the maximum value of 99:59:59, it will stop
  7. The timer shall have a start button which starts the timer
  8. The timer shall have a stop button which pauses the timer
  9. The timer should have a reset button which resets the timer to 0
  10. The timer shall be able to be directly edited to reflect any allowable time

*The Score Counters (F.3.X)*
  1. Each score counter shall be set to 0 upon startup
  2. Each score counter shall allow scores up to and including 990
  3. When 990 is reached, the +10 button will cease to function unless the score is decremented
  4. Each score counter shall only allow scores that are multiples of 10
  5. Each score counter shall have one button to add 10 points to the score, and one button that subtracts 10 points from the score
  6. Each score counter shall be able to be directly edited to reflect any allowable score

*The Notifications (F.4.X)*
  1. Notifications shall not affect states of the timer or score counters
  2. Notifications shall be acknowledged via button-click by the user before disappearing
  3. Once the notification is acknowledged, it will disappear from the notification window
  4. If a notification is not acknowledged before another notification needs to be issued, the newest notification will take precedence in the notification window
  5. Notifications shall display a visual message and issue an audible sound upon trigger
  6. A notification shall be delivered when the timer strikes 00:16:00 (Snitch Report)
  7. A notification shall be delivered when the timer strikes 00:17:00 (Seekers Report/Snitch Released)
  8. A notification shall be delivered when the timer strikes 00:18:00 (Seekers Released)
  9. A notification shall be delivered when the timer strikes 00:23:00 (First Handicap)
  10. A notification shall be delivered when the timer strikes 00:28:00 (Second Handicap)
  11. A notification shall be delivered when the timer strikes 00:33:00 (Third Handicap)

## Non-Functional Requirements (U.X)
  1. The application shall be written in Java
  2. The application shall be able to operate without an internet connection
  3. The application should be intuitive enough to be used without training within 15 minutes
  4. The application should be complete in six weeks or less by a team of four developers

## Appendix A
The following is the most-current mockup(s) of the application interface(s):

*The Primary Interface*

![](https://docs.google.com/drawings/d/sNWsLeWmKPSBR9fFCZ26ULQ/image?w=341&h=202&rev=257&ac=1&parent=1Di4C-ljlBX7sI4iNHnmsX2p94pMSmGGvsUq-GMB_iIg)

---
# Sprint 1
## Project Roles
**Jess** - Research Java graphics and implement basic interface.

**Yuyang & Anjali** - Implement timer and basic methods, text-based if necessary.

**Cong** - Implement score counters and basic methods, text based if necessary.

---
# Sprint 2
## Project Roles
**Jess** - Update Graphics to be more similar to mockups

**Yuyang** - Implement Graphics test suite

**Anjali** - Implement Timer test suite

**Cong** - Assist Yuyang & Cong with test development
