# Taxi Management (Multithreading)

## About
- This project is designed to allocate taxis to passengers.
- Passengers are generated every 3 seconds and Taxis are generated every 15 seconds.
- At most 5 taxis are available at the taxi stand, at a time.
- Taxi destination is set by it's first passenger.
- Taxi waits for 4 passengers to board or for maximum of 60 seconds after first passenger boards, before leaving the stand.
- Passenger can take the taxi if it has no destination set or is going to same destination as the passenger.
- Passenger initially checks for available taxis at an interval of 1 second. This interval decreases by 50 milli seconds on each iteration.

## Instructions for excecuting from command line
- Clone repo : `git clone https://github.com/devansh-accolite/assignments.git`
- `cd Assignment_15-01_Java_Multithreading/src`
- Compile all classes : `javac com/au/taximgmt/*.java`
- Execute TaxiStand class : `java com/au/taximgmt/TaxiStand`

## Class implementation
### TaxiStand.java
- Creates Passenger and Taxi queues.
- Creates Taxi stand of size 5.
- Starts Passenger generator and Taxi generator threads.
### TaxiGenerator.java
- Generates new Taxi objects every 15 seconds and adds to Taxi queue.
- Taxi objects are initialized with no destination and no passengers.
### PassengerGenerator.java
- Generates new Passenger objects every 3 seconds and adds to Passenger queue.
- Passengers are initialized with random destination.
### Taxi.java
- Checks taxi stand for empty slot every 1 second and moves taxi from queue to stand.
- Sets taxi destination once a passenger boards empty taxi and starts a timer for 60 seconds after which taxi leaves the stand.
- If maxmimum number of passengers (i.e. 4) have boarded the taxi before that, then taxi leaves the stand immediately.
### Passenger.java
- Checks for available taxis in taxi stand after specific intervals.
- Interval time is reduced by 50 milliseconds after every check.
- If suitable taxi is found, passenger leaves queue and boards taxi.
