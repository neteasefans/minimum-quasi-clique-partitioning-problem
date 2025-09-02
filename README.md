# An iterated local search for minimum quasi clique partitioning problem

The three sets of 321 benchmark instances, including 171 Small Set instances, 72 Large Sparse Set instances and 78 Large Dense Set instances used in our paper titled with "An iterated local search for minimum quasi clique partitioning problem" published in COR are mainly taken from the DIMACS Challenges, and networks from Moviegalaxies data set etc. [refer to [2]]. Each instance corresponds to an input graph and a required density value γ. To facilitate the further research, we upload the instances here.

The source code given in 'src' directory implements the proposed method described in our paper.

** Instructions to use the source code of ILS

*** To compile:

q.zhou$ javac Main.java Improve_new.java Clique.java AdEcount.java

q.zhou$

*** To run:

q.zhou$ java -cp . Main instanceName outputFile

(where -cp . indicates the current working directory, Main includes the main function, instanceName is the instance file and outputFile records the output information.)

Reference papers to the minimum quasi clique partitioning problem (MQCPP):

[1] Rafael A Melo, Celso C Ribeiro, and Jose A Riveaux. The minimum quasi-clique partitioning problem: Complexity, formulations, and a computational study. Information Sciences, 612:655–674, 2022.

[2] Rafael A Melo, Celso C Ribeiro, and Jose A Riveaux. A biased random-key genetic algorithm for the minimum quasi-clique partitioning problem. Annals of Operations Research, pages 1–33, 2023.

Please cite our work as: Zhou, Q., Zhu, T., Wu, Q., Jiang, Z. Z., & Wang, W. (2025). An efficient iterated local search for the minimum quasi-clique partitioning problem. Computers & Operations Research, 179, 107033.
