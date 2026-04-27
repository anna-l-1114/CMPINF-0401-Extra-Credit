# Extra Credit Project

## 1. What did you build?
*Briefly describe your project in 2–3 sentences. What does it do? What was your idea?*

> I built a pigeon quiz w/ GUI because I like pigeons a lot. It records user response then shows an 
> answer based on the response. 

---

## 2. What did you learn?
*What concept(s) did this project help you understand better or revise? How were you struggling with it before, and how do you understand it better now?*

> It helped me with GUI stuff like action listeners since I found that those topics were the ones I was most confused by throughout the course. I think I have a better grasp on how to translate how I want things to actually look to code, like where elements are placed. Mostly, I got to practice how to keep track of stuff and wrap my head around the code when there are numerous different parts that all interact with each other in various manners, especially when trying to deal with logical errors. I kept deleting stuff from the Lab 12 code I used because it was irrelevant to my final goal for the project, then had to go deal with the consequences of whatever thing I deleted messing up my code in some way I had to locate and didn't expect.    

---

## 3. Challenges & how you solved them
*What was the hardest part of the project and how did you work through it? How much help did you get, and from whom? (e.g., TAs, office hours, peers, documentation)*

> I mostly used the lecture slides, and if I ran into additional problems I would look up related topics and solutions on GeeksForGeeks and StackOverflow. For example, I was having trouble figuring out how to change the question layout to the result layout so I found a similar question on StackOverflow. The things I needed help on were wrapping the description text, how to clear an ArrayList, and updating the question lay out to result layout. I also asked my brother, who is a software engineer, about how to implement the random options while still tracking the individual answer scores. He was helpful at giving me a starting point/general idea for pseudocode. If I had started this earlier going to office hours probably would've been more efficient, but instead I looked at a bunch of different StackOverflow posts before finding the answer I was looking for. 

---

## 4. External sources
*List any external code or resources used, including anything reused from course materials. If you extended an existing project, describe what you added.*

| Lines / Section | Source or description | Why you used it |
|---|---|---|
| e.g. App.java Lines 42–58 | stackoverflow.com/... | Did not know how to implement X |
| PigeonQuiz class | Lab 12 Trivia.java | Used as a base for the quiz GUI and code, edited to exclude "correct answer" format, added following methods: determineAnswer() to pick a pigeon based on most common corresponding answer, findMaxIndices() helper method to find all indexes where the max values in an array occurs|
| Question Class | Lab 12 TextQuestion.java | removed irrelevant methods (methods involving score and correct answer/result)
| QuizView Class | Lab 12 TriviaView.java | Used as base code, got rid of all code involved with checking answer & adding up a correct answer score, modified methods to make options randomized, new method to display result screen, increased # of options by 1|
| QuizView.java Lines 110-120 | https://stackoverflow.com/questions/26420428/how-to-word-wrap-text-in-jlabel | Didn't know how to make a label that wrapped text |


---

## 5. Development log
*Log each work session below.*

| Date | Time spent | What I worked on |
|---|---|---|
| 4/24 | 20 minutes |Writing questions & editing/adding images|
| 4/25 | 15 minutes | Pigeon enum |
| 4/26 | ~3 hours | Editing code used from lab 12, getting rid of 'correct answer' functionalities, PigeonQuiz.java: code to add to individual pigeon type scores based on answer, determineAnswer(), findMaxIndices(); QuizView.java: modify setOptions() to make randomized options |
| 4/26 | ~3.5 hours | Messing with GUI stuff like background, element layout and sizes, adding comments, making other people test it, debug methods from previous session, QuizView.java: modify getSelectedAnswer() to account for randomized options, generateResultLayout() method| 

---

## 6. Self-assessment
*Give yourself a score out of 20. For each criterion, briefly justify your sub-score with specific evidence. Do not just state a number, explain your reasoning! Both underselling and overselling are considered during grading.*

| Criterion | Your reflection | Your score (out of 5) |
|---|---|---|
| Code quality & OOP principles | | 4/5 |
| Creativity & idea | | 2/5 |
| Difficulty & scope | | 3/5 |
| Learning & reflection depth | | 4/5 |
| **Total** | | **13/20** |

*In 2–3 sentences, summarize your total score:*

> I feel like I learned a lot because this gave me a lot of headaches. Code quality should be okay because from my testing it does what I want it to, readability and OOP visibility seems okay, not that confident about the efficiency of it all and error handling. Not very creative or difficult considering how heavily I relied on the Lab 12 code as a template. 
