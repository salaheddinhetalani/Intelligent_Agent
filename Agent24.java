package group24;

import negotiator.AgentID;
import negotiator.Bid;
import negotiator.actions.Accept;
import negotiator.actions.Action;
import negotiator.actions.Offer;
import negotiator.parties.AbstractNegotiationParty;
import negotiator.parties.NegotiationInfo;
import negotiator.analysis.MultilateralAnalysis;
import java.util.List;
import java.util.ArrayList;

public class Agent24 extends AbstractNegotiationParty 
{
    private final String description = "Agent24";

    private Bid lastReceivedOffer; // offer on the table
	private Bid lastAcceptedOffer; // offer on the table
    private Bid myLastOffer;
	private String LastTakenAction;

	private int dataTableIndex = 0;
	private static ArrayList<Wrapper> HistoryTable;
	@Override
    public void init(NegotiationInfo info) 
	{
        super.init(info);
		HistoryTable = new ArrayList<Wrapper>();
    }

    @Override
    public Action chooseAction(List<Class<? extends Action>> list) 
	{
        
		double time = getTimeLine().getTime();
		Bid myMaxUtilityBid = this.getMaxUtilityBid();
		double myMaxUtility = this.utilitySpace.getUtility(this.getMaxUtilityBid());
		/****************************************************************************/
		if (time < 0.1) 
		{
			return OfferBid(generateRandomBidWithUtility(myMaxUtility-0.1));
		}
		/****************************************************************************/
		else if (0.1 <= time && time < 0.4)
		{
			for(double t = 0.1; t <= 0.4; t+=0.05)
			{
				if(time > t-0.005 && time < t+0.005)
				{
					myLastOffer = generateRandomBidWithUtility(myMaxUtility);
					return OfferBid(myLastOffer);
				}		
			}
			Bid P0MaxBid = Partner0MaxUtilityBid();
			Bid P1MaxBid = Partner1MaxUtilityBid();
			
			double P0MaxUtil = (P0MaxBid == null ? 0 : this.utilitySpace.getUtility(P0MaxBid));
			double P1MaxUtil = (P1MaxBid == null ? 0 : this.utilitySpace.getUtility(P1MaxBid));
			
			if(P0MaxUtil > P1MaxUtil && P0MaxUtil >= 0.8){
				myLastOffer = P0MaxBid;
				return OfferBid(P0MaxBid);
			}
			else if (P1MaxUtil > P0MaxUtil && P1MaxUtil >= 0.8){
				myLastOffer = P1MaxBid;
				return OfferBid(P1MaxBid);
			}
			else {
				if (lastReceivedOffer != null && myLastOffer != null)
				{
					double myLastOfferUtility = this.utilitySpace.getUtility(myLastOffer);
					double lastReceivedOfferUtility = this.utilitySpace.getUtility(lastReceivedOffer);
					
					//lastReceivedOffer is better than myLastOffer --> take it
					if(lastReceivedOfferUtility >= 0.8)
					{
						//myLastOffer = lastReceivedOffer;
						return AcceptBid(lastReceivedOffer);
					}
					else //lastReceivedOffer is not better than myLastOffer --> average
					{
						myLastOffer = generateRandomBidWithUtility((myLastOfferUtility+lastReceivedOfferUtility) / 2);
						return OfferBid(myLastOffer);
					}	
				}
				else // no myLastOffer yet
				{
				myLastOffer = generateRandomBidWithUtility(myMaxUtility);
					return OfferBid(myLastOffer);
				}	
			}
		}
		/****************************************************************************/
		else if (0.4 <= time && time < 0.6)
		{
			for(double t = 0.4; t <= 0.6; t+=0.05)
			{
				if(time > t-0.005 && time < t+0.005)
				{
					myLastOffer = generateRandomBidWithUtility(myMaxUtility);
					return OfferBid(myLastOffer);
				}
			}
			Bid P0MaxBid = Partner0MaxUtilityBid();
			Bid P1MaxBid = Partner1MaxUtilityBid();

			double P0MaxUtil = (P0MaxBid == null ? 0 : this.utilitySpace.getUtility(P0MaxBid));
			double P1MaxUtil = (P1MaxBid == null ? 0 : this.utilitySpace.getUtility(P1MaxBid));

			if(P0MaxUtil > P1MaxUtil && P0MaxUtil >= 0.75){
				myLastOffer = P0MaxBid;
				return OfferBid(P0MaxBid);
			}
			else if (P1MaxUtil > P0MaxUtil && P1MaxUtil >= 0.75){
				myLastOffer = P1MaxBid;
				return OfferBid(P1MaxBid);
			}
			else
			{
				double lastReceivedOfferUtility = this.utilitySpace.getUtility(lastReceivedOffer);
				if(lastReceivedOfferUtility >= 0.75)
				{
					return AcceptBid(lastReceivedOffer);
				}
				else
				{
					double myLastOfferUtility = this.utilitySpace.getUtility(myLastOffer);
					myLastOffer = generateRandomBidWithUtility((myLastOfferUtility+lastReceivedOfferUtility) / 2);
					return OfferBid(myLastOffer);
				}
			}
		}
		/****************************************************************************/
		else if (0.6 <= time && time < 0.8)
		{
			for(double t = 0.6; t <= 0.8; t+=0.05)
			{
				if(time > t-0.005 && time < t+0.005)
				{
					myLastOffer = generateRandomBidWithUtility(myMaxUtility);
					return OfferBid(myLastOffer);
				}
			}
			Bid P0MaxBid = Partner0MaxUtilityBid();
			Bid P1MaxBid = Partner1MaxUtilityBid();

			double P0MaxUtil = (P0MaxBid == null ? 0 : this.utilitySpace.getUtility(P0MaxBid));
			double P1MaxUtil = (P1MaxBid == null ? 0 : this.utilitySpace.getUtility(P1MaxBid));

			if(P0MaxUtil > P1MaxUtil && P0MaxUtil >= 0.70){
				myLastOffer = P0MaxBid;
				return OfferBid(P0MaxBid);
			}
			else if (P1MaxUtil > P0MaxUtil && P1MaxUtil >= 0.70){
				myLastOffer = P1MaxBid;
				return OfferBid(P1MaxBid);
			}
			else
			{
				double lastReceivedOfferUtility = this.utilitySpace.getUtility(lastReceivedOffer);
				if(lastReceivedOfferUtility >= 0.70)
				{
					return AcceptBid(lastReceivedOffer);
				}
				else
				{
					double myLastOfferUtility = this.utilitySpace.getUtility(myLastOffer);
					myLastOffer = generateRandomBidWithUtility((myLastOfferUtility+lastReceivedOfferUtility) / 2);
					return OfferBid(myLastOffer);
				}
			}
		}
		/****************************************************************************/
		else if(0.8 <= time && time < 0.9)
		{
			for(double t = 0.8; t <= 0.9; t+=0.05)
			{
				if(time > t-0.005 && time < t+0.005)
				{
					myLastOffer = generateRandomBidWithUtility(myMaxUtility);
					return OfferBid(myLastOffer);
				}
			}
			Bid P0MaxAcceptedBid = Partner0MaxAcceptedBidUtil();
			Bid P1MaxAcceptedBid = Partner1MaxAcceptedBidUtil();

			double P0MaxAcceptedUtil = (P0MaxAcceptedBid == null ? 0 : this.utilitySpace.getUtility(P0MaxAcceptedBid));
			double P1MaxAcceptedUtil = (P1MaxAcceptedBid == null ? 0 : this.utilitySpace.getUtility(P1MaxAcceptedBid));

			if(P0MaxAcceptedUtil > P1MaxAcceptedUtil && P0MaxAcceptedUtil >= 0.75){
				myLastOffer = P0MaxAcceptedBid;
				return OfferBid(P0MaxAcceptedBid);
			}
			else if (P1MaxAcceptedUtil > P0MaxAcceptedUtil && P1MaxAcceptedUtil >= 0.75){
				myLastOffer = P1MaxAcceptedBid;
				return OfferBid(P1MaxAcceptedBid);
			}
			else
			{
				double lastReceivedOfferUtility = this.utilitySpace.getUtility(lastReceivedOffer);
				if(lastReceivedOfferUtility >= 0.75)
				{
					return AcceptBid(lastReceivedOffer);
				}
				else
				{
					double myLastOfferUtility = this.utilitySpace.getUtility(myLastOffer);
					myLastOffer = generateRandomBidWithUtility((myLastOfferUtility+lastReceivedOfferUtility) / 2);
					return OfferBid(myLastOffer);
				}
			}
		}
		/****************************************************************************/
		else if(0.9 <= time && time < 0.95)
		{
			for(double t = 0.9; t <= 0.95; t+=0.05)
			{
				if(time > t-0.005 && time < t+0.005)
				{
					myLastOffer = generateRandomBidWithUtility(myMaxUtility);
					return OfferBid(myLastOffer);
				}
			}
			Bid P0MaxAcceptedBid = Partner0MaxAcceptedBidUtil();
			Bid P1MaxAcceptedBid = Partner1MaxAcceptedBidUtil();

			double P0MaxAcceptedUtil = (P0MaxAcceptedBid == null ? 0 : this.utilitySpace.getUtility(P0MaxAcceptedBid));
			double P1MaxAcceptedUtil = (P1MaxAcceptedBid == null ? 0 : this.utilitySpace.getUtility(P1MaxAcceptedBid));

			if(P0MaxAcceptedUtil > P1MaxAcceptedUtil && P0MaxAcceptedUtil >= 0.71){
				myLastOffer = P0MaxAcceptedBid;
				return OfferBid(P0MaxAcceptedBid);
			}
			else if (P1MaxAcceptedUtil > P0MaxAcceptedUtil && P1MaxAcceptedUtil >= 0.71){
				myLastOffer = P1MaxAcceptedBid;
				return OfferBid(P1MaxAcceptedBid);
			}
			else
			{
				double lastReceivedOfferUtility = this.utilitySpace.getUtility(lastReceivedOffer);
				if(lastReceivedOfferUtility >= 0.71)
				{
					return AcceptBid(lastReceivedOffer);
				}
				else
				{
					double myLastOfferUtility = this.utilitySpace.getUtility(myLastOffer);
					myLastOffer = generateRandomBidWithUtility((myLastOfferUtility+lastReceivedOfferUtility) / 1.95);
					return OfferBid(myLastOffer);
				}
			}
		}
		/****************************************************************************/
		else if(0.95 <= time && time < 0.97)
		{
			double lastReceivedOfferUtility = this.utilitySpace.getUtility(lastReceivedOffer);
			if(lastReceivedOfferUtility >= 0.69)
			{
				return AcceptBid(lastReceivedOffer);
			}
			else
			{
				return OfferBid(generateRandomBidWithUtility(myMaxUtility-0.2));
			}
		}
		/****************************************************************************/
		else if(0.97 <= time && time < 0.98)
		{
			double lastReceivedOfferUtility = this.utilitySpace.getUtility(lastReceivedOffer);
			if(lastReceivedOfferUtility >= 0.67)
			{
				return AcceptBid(lastReceivedOffer);
			}
			else
			{
				return OfferBid(generateRandomBidWithUtility(myMaxUtility-0.25));
			}
		}
		/****************************************************************************/
		else if(0.98 <= time && time < 0.989)
		{
			double lastReceivedOfferUtility = this.utilitySpace.getUtility(lastReceivedOffer);
			if(lastReceivedOfferUtility >= 0.65)
			{
				return AcceptBid(lastReceivedOffer);
			}
			else
			{
				return OfferBid(generateRandomBidWithUtility(myMaxUtility-0.25));
			}
		}		
		/****************************************************************************/
		else if(0.989 <= time && time < 0.994)
		{
			double lastReceivedOfferUtility = this.utilitySpace.getUtility(lastReceivedOffer);
			if(lastReceivedOfferUtility >= 0.57)
			{
				return AcceptBid(lastReceivedOffer);
			}
			else
			{
				return OfferBid(generateRandomBidWithUtility(myMaxUtility-0.2));
			}
		}
		/****************************************************************************/
		else //if(0.994 <= time && time<= 1)
		{
			double lastReceivedOfferUtility = this.utilitySpace.getUtility(lastReceivedOffer);
			if(lastReceivedOfferUtility >= 0.37)
			{
				return AcceptBid(lastReceivedOffer);
			}
			else
			{
				return OfferBid(generateRandomBidWithUtility(myMaxUtility-0.25));
			}
		}
	}
    
    @Override
    public void receiveMessage(AgentID sender, Action act) 
	{
        super.receiveMessage(sender, act);

        if (act instanceof Offer) { // sender is making an offer
            
			Offer offer = (Offer) act;
			lastReceivedOffer = offer.getBid();
			LastTakenAction = "Offer";
            
			// Add Bid, Utility and time for opponents' offers to Bid History
			
			double lastReceivedOfferUtility = this.utilitySpace.getUtility(lastReceivedOffer);
			double timeNow = getTimeLine().getTime();
			Wrapper w = new Wrapper(sender,LastTakenAction,lastReceivedOffer,lastReceivedOfferUtility,timeNow);
			HistoryTable.add(w);

        }
		else if (act instanceof Accept) { // sender is accepting an offer
			
			Accept accept = (Accept) act;
			lastAcceptedOffer = accept.getBid();
			LastTakenAction = "Accept";
			
			double lastAcceptedOfferUtility = this.utilitySpace.getUtility(lastAcceptedOffer);
			double timeNow = getTimeLine().getTime();
			Wrapper w = new Wrapper(sender,LastTakenAction,lastAcceptedOffer,lastAcceptedOfferUtility,timeNow);
			HistoryTable.add(w);
        }
    }
	
    @Override
    public String getDescription() 
	{
        return description;
    }

    private Bid getMaxUtilityBid() 
	{
        try {
            return this.utilitySpace.getMaxUtilityBid();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
	
	public Bid generateRandomBidWithUtility(double utilityThreshold) 
	{
      Bid randomBid;
      double utility;
      do {
          randomBid = generateRandomBid();
          try {
              utility = utilitySpace.getUtility(randomBid);
          } catch (Exception e)
          {
              utility = 0.0;
          }
      }
      while (utility < utilityThreshold);
      return randomBid;
	}
	
	private Accept AcceptBid(Bid bid)
	{
		return new Accept(this.getPartyId(), bid);
	}
	
	private Offer OfferBid(Bid bid)
	{
		double myLastOfferUtility = this.utilitySpace.getUtility(bid);
		double timeNow = getTimeLine().getTime();
		String MyLastAction = "Offer";
		Wrapper w = new Wrapper(this.getPartyId(),MyLastAction,bid,myLastOfferUtility,timeNow);
		HistoryTable.add(w);
		return new Offer(this.getPartyId(), bid);
	}
	
	private AgentID[] PartnersIDs()
	{
		AgentID[] IDs = new AgentID[2];
		
		AgentID MyID = this.getPartyId();
		
		AgentID a,b;
		
		AgentID x = HistoryTable.get(0).WrapperAgentID;
		AgentID y = HistoryTable.get(1).WrapperAgentID;
		AgentID z = HistoryTable.get(2).WrapperAgentID;
		
		if(x == MyID){
			a = y;
			b = z;
		}
		else if(y == MyID){
			a = x;
			b = z;
		}
		else{
			a = x;
			b = y;
		}
		IDs[0] = a;
		IDs[1] = b;
		
		return IDs;	
	}
	/****************************************************************************/
	private Bid Partner0MaxUtilityBid()
	{
		AgentID[] IDs = PartnersIDs();
		double maxUtilityForAgent0 = 0;
		Bid maxUtilityBidForAgent0 = null;
		for(Wrapper w: HistoryTable)
		{
			if(w.WrapperAgentID == IDs[0] && w.WrapperAction == "Offer")
			{
				if(w.WrapperUtility > maxUtilityForAgent0){
					maxUtilityForAgent0 = w.WrapperUtility;
					maxUtilityBidForAgent0 = new Bid(w.WrapperBid);
				}
			}	
		}
		return maxUtilityBidForAgent0;
	}
	/****************************************************************************/
	private Bid Partner0MaxAcceptedBidUtil()
	{
		AgentID[] IDs = PartnersIDs();
		double maxUtilityForAgent0 = 0;
		Bid maxUtilityBidForAgent0 = null;
		for(Wrapper w : HistoryTable)
		{
			if(w.WrapperAgentID == IDs[0] && w.WrapperAction == "Accept")
			{
				if(w.WrapperUtility > maxUtilityForAgent0){
					maxUtilityForAgent0 = w.WrapperUtility;
					maxUtilityBidForAgent0 = new Bid(w.WrapperBid);
				}
			}	
		}
		return maxUtilityBidForAgent0;
	}
	/****************************************************************************/
	private Bid Partner1MaxUtilityBid()
	{
		AgentID[] IDs = PartnersIDs();
		double maxUtilityForAgent1 = 0;
		Bid maxUtilityBidForAgent1 = null;
		for(Wrapper w : HistoryTable)
		{
			if(w.WrapperAgentID == IDs[1] && w.WrapperAction == "Offer")
			{
				if(w.WrapperUtility > maxUtilityForAgent1){
					maxUtilityForAgent1 = w.WrapperUtility;
					maxUtilityBidForAgent1 = new Bid(w.WrapperBid);
				}
			}	
		}
		return maxUtilityBidForAgent1;
	}
	/****************************************************************************/
	private Bid Partner1MaxAcceptedBidUtil()
	{
		AgentID[] IDs = PartnersIDs();
		double maxUtilityForAgent1 = 0;
		Bid maxUtilityBidForAgent1 = null;
		for(Wrapper w : HistoryTable)
		{
			if(w.WrapperAgentID == IDs[1] && w.WrapperAction == "Accept")
			{
				if(w.WrapperUtility > maxUtilityForAgent1){
					maxUtilityForAgent1 = w.WrapperUtility;
					maxUtilityBidForAgent1 = new Bid(w.WrapperBid);
				}
			}	
		}
		return maxUtilityBidForAgent1;
	}
	/****************************************************************************/
}
class Wrapper
{
	public AgentID WrapperAgentID;
	public String WrapperAction;
	public Bid WrapperBid;
	public double WrapperUtility;
	public double WrapperTime;
	
	public Wrapper(AgentID agent_id, String action, Bid bid, double util, double t){
		WrapperAgentID = agent_id;
		WrapperAction = action;
		WrapperBid = bid;
		WrapperUtility = util;
		WrapperTime = t;
	}
}