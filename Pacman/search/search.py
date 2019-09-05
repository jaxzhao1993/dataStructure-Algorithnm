# search.py
# ---------
# Licensing Information:  You are free to use or extend these projects for
# educational purposes provided that (1) you do not distribute or publish
# solutions, (2) you retain this notice, and (3) you provide clear
# attribution to UC Berkeley, including a link to http://ai.berkeley.edu.
# 
# Attribution Information: The Pacman AI projects were developed at UC Berkeley.
# The core projects and autograders were primarily created by John DeNero
# (denero@cs.berkeley.edu) and Dan Klein (klein@cs.berkeley.edu).
# Student side autograding was added by Brad Miller, Nick Hay, and
# Pieter Abbeel (pabbeel@cs.berkeley.edu).


"""
In search.py, you will implement generic search algorithms which are called by
Pacman agents (in searchAgents.py).
"""

import util

class SearchProblem:
    """
    This class outlines the structure of a search problem, but doesn't implement
    any of the methods (in object-oriented terminology: an abstract class).

    You do not need to change anything in this class, ever.
    """

    def getStartState(self):
        """
        Returns the start state for the search problem.
        """
        util.raiseNotDefined()

    def isGoalState(self, state):
        """
          state: Search state

        Returns True if and only if the state is a valid goal state.
        """
        util.raiseNotDefined()

    def getSuccessors(self, state):
        """
          state: Search state

        For a given state, this should return a list of triples, (successor,
        action, stepCost), where 'successor' is a successor to the current
        state, 'action' is the action required to get there, and 'stepCost' is
        the incremental cost of expanding to that successor.
        """
        util.raiseNotDefined()

    def getCostOfActions(self, actions):
        """
         actions: A list of actions to take

        This method returns the total cost of a particular sequence of actions.
        The sequence must be composed of legal moves.
        """
        util.raiseNotDefined()


def tinyMazeSearch(problem):
    """
    Returns a sequence of moves that solves tinyMaze.  For any other maze, the
    sequence of moves will be incorrect, so only use this for tinyMaze.
    """
    from game import Directions
    s = Directions.SOUTH
    w = Directions.WEST
    return  [s, s, w, s, w, w, s, w]

def depthFirstSearch(problem):
    """
    Search the deepest nodes in the search tree first.

    Your search algorithm needs to return a list of actions that reaches the
    goal. Make sure to implement a graph search algorithm.

    To get started, you might want to try some of these simple commands to
    understand the search problem that is being passed in:

    print("Start:", problem.getStartState())
    print("Is the start a goal?", problem.isGoalState(problem.getStartState()))
    print("Start's successors:", problem.getSuccessors(problem.getStartState()))
    """
    "*** YOUR CODE HERE IF YOU WANT TO PRACTICE ***"
    from game import Directions
    from game import Agent
    from game import Actions
    from game import Configuration
    from util import Stack
    from searchAgents import PositionSearchProblem
    s = Directions.SOUTH
    w = Directions.WEST
    n = Directions.NORTH
    e = Directions.EAST

    currentPos = problem.getStartState()
    stack = Stack() #只存坐标
    stack.push(currentPos)
    seen = set()
    seen.add(currentPos)
    parent = {}
    actionRecord = {}
    while (not stack.isEmpty()):
        vertex = stack.pop()
        ##得到可能的下个点
        node = problem.getSuccessors(vertex)
        ##返回的是一个列表+元组
        for x in range(0, len(node)):
            nodeState = node[x][0]  #转化为state
            nodeAction = node[x][1]
            if nodeState not in seen:
                parent[nodeState] = vertex
                actionRecord[nodeState] = nodeAction
                stack.push(nodeState)
                seen.add(nodeState)
            if problem.isGoalState(nodeState):
                path=[nodeState]
                actionPath = [actionRecord[nodeState]]
                while path[-1] !=currentPos and parent[path[-1]]!=currentPos:
                    parentNode = parent[path[-1]]
                    path.append(parentNode)
                    actionPath.append(actionRecord[parentNode])
                path.reverse()
                actionPath.reverse()
                #print(path)
                #print(actionPath)
                #print(problem.getCostOfActions(actionPath))
                return actionPath
    return  [w]

    util.raiseNotDefined()

def breadthFirstSearch(problem):
    """Search the shallowest nodes in the search tree first."""
    "*** YOUR CODE HERE IF YOU WANT TO PRACTICE ***"
    from game import Directions
    from game import Agent
    from game import Actions
    from game import Configuration
    from util import Queue
    from searchAgents import PositionSearchProblem
    s = Directions.SOUTH
    w = Directions.WEST
    n = Directions.NORTH
    e = Directions.EAST

    currentPos = problem.getStartState()
    node = problem.getSuccessors(currentPos)
    queue = [] #只存坐标
    queue.append(currentPos)
    seen = set()
    seen.add(currentPos)
    parent = {}
    actionRecord = {}
    while (len(queue)>0):
        vertex = queue.pop(0)
        ##得到可能的下个点
        node = problem.getSuccessors(vertex)
        ##返回的是一个列表+元组
        for x in range(0, len(node)):
            nodeState = node[x][0]  #转化为state
            nodeAction = node[x][1]
            if nodeState not in seen:
                parent[nodeState] = vertex
                actionRecord[nodeState] = nodeAction
                queue.append(nodeState)
                seen.add(nodeState)
            if problem.isGoalState(nodeState):
                path=[nodeState]
                actionPath = [nodeAction]
                while path[-1] !=currentPos and parent[path[-1]]!=currentPos:
                    parentNode = parent[path[-1]]
                    path.append(parentNode)
                    actionPath.append(actionRecord[parentNode])
                path.reverse()
                actionPath.reverse()
                #print(path)
                #print(actionPath)
                #print(problem.getCostOfActions(actionPath))
                return actionPath
    return  [s]
    util.raiseNotDefined()

def uniformCostSearch(problem, heuristic):
    """Search the node of least total cost first."""
    "*** YOUR CODE HERE IF YOU WANT TO PRACTICE ***" 
def nullHeuristic(state, problem=None):
    """
    A heuristic function estimates the cost from the current state to the nearest
    goal in the provided SearchProblem.  This heuristic is trivial.
    """
    return 0

def aStarSearch(problem, heuristic=nullHeuristic):
    """Search the node that has the lowest combined cost and heuristic first."""
    "*** YOUR CODE HERE IF YOU WANT TO PRACTICE ***"
    from util import PriorityQueue
    from game import Directions
    s = Directions.SOUTH
    w = Directions.WEST
    n = Directions.NORTH
    e = Directions.EAST

    Frontier = PriorityQueue()
    openSet = set()
    closed=set()
    startPoint = problem.getStartState()
    Frontier.push( startPoint, heuristic(startPoint, problem) ) 
    gCostNow={startPoint:0}
    fCost = {startPoint: heuristic(startPoint, problem)+0}
    parent={}
    actionRecord={}

    while not Frontier.isEmpty():
        currentPos = Frontier.pop()

        if currentPos not in closed:
            closed.add(currentPos)
        
        if problem.isGoalState(currentPos):
            path=[currentPos]
            actionPath = [actionRecord[currentPos]]
            while path[-1] !=startPoint and parent[path[-1]]!=startPoint:
                parentNode = parent[path[-1]]
                path.append(parentNode)
                actionPath.append(actionRecord[parentNode])
            path.reverse()
            actionPath.reverse()
            #print(path)
            #print(actionPath)
            return actionPath
        for neighbour in problem.getSuccessors(currentPos):
            nodeState = neighbour[0]
            nodeAction = neighbour[1]
            cost_toNeighhbour = gCostNow[currentPos]+1
            if nodeState not in closed or cost_toNeighhbour< gCostNow[nodeState]:
                gCostNow[nodeState] = cost_toNeighhbour
                fCost[nodeState] = gCostNow[nodeState]+ heuristic(nodeState,problem)
                parent[nodeState] = currentPos
                actionRecord[nodeState] = nodeAction
                Frontier.update(nodeState, fCost[nodeState])



    util.raiseNotDefined()
    # openSet = []
    # startPoint = problem.getStartState()
    # closedSet = set()
    # openSet.append(startPoint)
    # parent = {}
    # parent[startPoint] = None
    # fCost = {}
    # gCostNow = {}
    # gCostNow[startPoint] = 0
    # actionRecord = {}
    # fCost[startPoint] = gCostNow[startPoint]+heuristic(startPoint,problem)
    # while(len(openSet)!=0):
    #     currentPos = openSet[0]
    #     for newPostion in openSet:    
    #         if(fCost[newPostion] < fCost[currentPos] or 
    #             (fCost[newPostion] == fCost[currentPos] and
    #             heuristic(startPoint,problem)< heuristic(startPoint,problem))):
    #             currentPos = newPostion
        
    #     openSet.remove(currentPos)
    #     closedSet.add(currentPos)

    #     if(problem.isGoalState(currentPos)):
    #         path=[currentPos]
    #         actionPath = [actionRecord[currentPos]]
    #         while path[-1] !=startPoint and parent[path[-1]]!=startPoint:
    #             parentNode = parent[path[-1]]
    #             path.append(parentNode)
    #             actionPath.append(actionRecord[parentNode])
    #         path.reverse()
    #         actionPath.reverse()
    #         print(path)
    #         print(actionPath)
    #         return actionPath

    #     node = problem.getSuccessors(currentPos)
    #     for x in range(len(node)):
    #         nodeState = node[x][0]
    #         nodeAction= node[x][1]
    #         cost_toNeighhbour = gCostNow[currentPos]+1
    #         if nodeState not in gCostNow.keys():
    #             gCostNow[nodeState] = cost_toNeighhbour
    #         if nodeState not in closedSet:
    #             fCost[nodeState] = gCostNow[nodeState] + heuristic(nodeState,problem)
    #             if nodeState not in openSet:
    #                 openSet.append(nodeState)
    #                 parent[nodeState] = currentPos
    #                 actionRecord[nodeState] = nodeAction
    #             else:
    #                 if gCostNow[nodeState]> cost_toNeighhbour:
    #                     gCostNow[nodeState] = cost_toNeighhbour
    #                     parent[nodeState] = currentPos
    #                     actionRecord[nodeState] = nodeAction



    # return [w]
    util.raiseNotDefined()

def iterativeDeepeningSearch(problem):
    """Search the deepest node in an iterative manner."""
    "*** YOUR CODE HERE FOR TASK 1 ***"
    from game import Directions
    from game import Agent
    from game import Actions
    from game import Configuration
    from util import Stack
    from searchAgents import PositionSearchProblem
    s = Directions.SOUTH
    w = Directions.WEST
    n = Directions.NORTH
    e = Directions.EAST

    limit = 0
    isFound = False
    while(not isFound):
        limit = limit+1   
        stack = Stack()
        startPoint = problem.getStartState()
        stack.push(startPoint)
        depthDic = {}
        depthDic[startPoint] = 0
        seen = set()
        parent ={}
        actionRecord = {}
        while( not stack.isEmpty()):
            currentPos = stack.pop()
            if(problem.isGoalState(currentPos)):
                isFound = True
                path=[currentPos]
                actionPath = [actionRecord[currentPos]]
                while path[-1] !=startPoint and parent[path[-1]]!=startPoint:
                    parentNode = parent[path[-1]]
                    path.append(parentNode)
                    actionPath.append(actionRecord[parentNode])
                #print(path)
                actionPath.reverse()
                #print(actionPath)
                return actionPath

            if(depthDic[currentPos] >= limit):
                continue

            node = problem.getSuccessors(currentPos)
            for x in range(0, len(node)):
                nodeState = node[x][0]
                nodeAction = node[x][1]
                if nodeState not in seen:
                    parent[nodeState] = currentPos
                    actionRecord[nodeState] = nodeAction
                    depthDic[nodeState] = depthDic[currentPos] + 1
                    stack.push(nodeState)
                    seen.add(nodeState)

        
    return

def waStarSearch(problem, heuristic=nullHeuristic):
    """Search the node that has has the weighted (x 2) lowest combined cost and heuristic first."""
    "*** YOUR CODE HERE FOR TASK 2 ***"
    from util import PriorityQueue
    from game import Directions
    s = Directions.SOUTH
    w = Directions.WEST
    n = Directions.NORTH
    e = Directions.EAST

    Frontier = PriorityQueue()
    closed=set()
    startPoint = problem.getStartState()
    gCostNow={startPoint:0}
    fCost = {startPoint: 2*heuristic(startPoint, problem)+0}
    actionPath = []
    Frontier.push( (startPoint, actionPath), fCost[startPoint] ) 
    parent={}

    while not Frontier.isEmpty():
        firstNode = Frontier.pop()
        currentPos = firstNode[0]
        actionPath = firstNode[1]

        if problem.isGoalState(currentPos):
            path=[currentPos]
            while path[-1] !=startPoint:
                parentNode = parent[path[-1]]
                path.append(parentNode)
            path.reverse()
            #print(path)
            #print(actionPath)
            return actionPath
        if currentPos not in closed:
            closed.add(currentPos)

        for neighbour in problem.getSuccessors(currentPos):
            nodeState = neighbour[0]
            nodeAction = neighbour[1]

            if nodeState not in gCostNow.keys() and nodeState not in closed:
                gCostNow[nodeState] = problem.getCostOfActions(actionPath+[nodeAction])
                fCost[nodeState] = gCostNow[nodeState]+ 2*heuristic(nodeState,problem)
                parent[nodeState] = currentPos
                newUpdate(Frontier,(nodeState, actionPath+[nodeAction]), fCost[nodeState])

def newUpdate(PriorityQueue, item, priority):
    for index, (p, c, i) in enumerate(PriorityQueue.heap):
        if i[0] == item[0]:
            if p <= priority:
                break
            del PriorityQueue.heap[index]
            PriorityQueue.heap.append((priority, c, item))
            heapq.heapify(PriorityQueue.heap)
            break
    else:
        PriorityQueue.push(item, priority)




# Abbreviations
bfs = breadthFirstSearch
dfs = depthFirstSearch
astar = aStarSearch
ucs = uniformCostSearch
ids = iterativeDeepeningSearch
wastar = waStarSearch
