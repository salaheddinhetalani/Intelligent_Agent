# Intelligent_Agent
Intelligent Agent Implementation for Automated Negotiation Agent Competition

## Overall Objective
Designing an agent for the Automated Negotiating Agents Competition (ANAC) Using the GENIUS framework which is implemented in JAVA.

### Competition Protocol
The protocol used for each negotiation during the tournament, is the Stacked Alternating Offers Protocol, in which each agent can take one of the following actions: either make an offer, or accept the last proposed offer or walk way. This process is repeated in a turn until reaching an agreement or reaching the deadline without any agreement.

Each agent has its own preference profile that is represented by means of additive utility functions that are computed as a weighted sum of the values associated with each of the issues.

### Agent Strategy
The proposed strategy for Agent24 is basically based on the time, the received opponents’ offers and the accepted offers by opponents throughout the whole negotiation.

For this purpose, an array list has been used to store for each round of the negotiation the corresponding normalized time at which an action is taken, the corresponding ID of the agent that takes the action, the action itself, and the bid that has been offered or accepted as well as its corresponding utility.

For more details of the design please refer to the report https://github.com/salaheddinhetalani/Intelligent_Agent/blob/master/IA_Report.pdf
