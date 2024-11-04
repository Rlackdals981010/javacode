import java.util.*;

class Solution {

    class Plan {
        String name;
        int start;
        int playtime;

        Plan(String name, int start, int playtime) {
            this.name = name;
            this.start = start;
            this.playtime = playtime;
        }
    }

    public String[] solution(String[][] plansData) {
        Stack<Plan> notFinish = new Stack<>();    // 남은 과제들
        List<String> finished = new ArrayList<>();  // 끝난 과제들

        PriorityQueue<Plan> plans = new PriorityQueue<>(Comparator.comparingInt(plan -> plan.start));

        for (String[] planData : plansData) {
            String name = planData[0];
            int start = convertToMinutes(planData[1]); 
            int playtime = Integer.parseInt(planData[2]);
            plans.offer(new Plan(name, start, playtime));
        }

        Plan nowPlan = plans.poll(); 
        int currentTime = nowPlan.start;

        while (!plans.isEmpty()) {
            Plan nextPlan = plans.poll();

            int endTime = currentTime + nowPlan.playtime;

            if (endTime == nextPlan.start) {
                finished.add(nowPlan.name);
                currentTime = nextPlan.start;
            }

            else if (endTime < nextPlan.start) {
                finished.add(nowPlan.name);
                currentTime = endTime;

                int remainingTime = nextPlan.start - currentTime;
                while (!notFinish.isEmpty() && remainingTime > 0) {
                    Plan pausedPlan = notFinish.pop();
                    if (pausedPlan.playtime <= remainingTime) {
                        finished.add(pausedPlan.name);
                        remainingTime -= pausedPlan.playtime;
                        currentTime += pausedPlan.playtime;
                    } else {
                        pausedPlan.playtime -= remainingTime;
                        notFinish.push(pausedPlan);
                        currentTime = nextPlan.start;
                        break;
                    }
                }
                currentTime = nextPlan.start;
            }

            else {
                nowPlan.playtime -= (nextPlan.start - currentTime);
                notFinish.push(nowPlan);
                currentTime = nextPlan.start;
            }
            nowPlan = nextPlan;
        }

        finished.add(nowPlan.name);
        while (!notFinish.isEmpty()) {
            finished.add(notFinish.pop().name);
        }

        return finished.toArray(new String[0]);
    }

    private int convertToMinutes(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return hours * 60 + minutes;
    }
}
