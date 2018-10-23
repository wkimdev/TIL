## http://remix.ethereum.org

## voting solidity example
- error issue..

  
```

pragma solidity 0.4.25;

contract Vote {
    // structure
    struct candidator {
        string name;
        uint upVote;
    }
    
    // variable
	bool live;
	address owner;
    candidator[] public candidatorList;
    
    // mapping
	mapping(address => bool) Voted;
    
    // event
    event AddCandidator(string name);
	event UpVote(string candidator, uint upVote);
	event FinishVote(bool live);
	event Voting(address owner);
	
    
    // modifier (voting�� �ƹ��� �� �� ���Բ�)
	modifier onlyOwner {  
		require(msg.sender == owner);
		_;
	}
    
    // constructor
	constructor() public {
		owner = msg.sender;
		live = true;
		
		emit Voting(owner);
	}
    
    // candidator
    function addCandidator(string _name) public onlyOwner{
        require(live == true);
		require(candidatorList.length < 5);		
        //5 �̻��̸� ������ �ȵǾ ������ ������ �� �ִ�?
        candidatorList.push(candidator(_name, 0));
        
        // emit event
        emit addCandidator(_name);
    }

    // voting
    function upVote(uint _indexOfCandidator) public {
        require(_indexOfCandidator < _candidatorList.length);
		require(Voted[msg.sender] == false);
        candidatorList[_indexOfCandidator].upVote++;
		
		
		// �̹� ������ �� ����� ������ ���ϵ��� ���´�.
		Voted[msg.sender] = true; //send ��ɾ�
					
		
		emit UpVote(candidatorList[_indexOfCandidator].name, candidatorList[_indexOfCandidator].upVote);
    }
    
    // finish vote
    function finishVote() public onlyOwner{
		live = false;
		
		emit FinishVote(live);
        
    }

}


```
