# 프로그래머스 길찾기 게임 - 2019 카카오
from collections import defaultdict
import sys
sys.setrecursionlimit(10**6)
MAX = 1e9
MIN = -1
TREE_DEPTH = 0

def solution(nodeinfo):
    global TREE_DEPTH

    pre_tree = defaultdict(list)
    post_tree = defaultdict(list)
    level = set()

    for i in range(len(nodeinfo)):
        x, y = nodeinfo[i]
        pre_tree[y].append((x, i+1))
        post_tree[y].append((x, i+1))
        level.add(y)
    
    for i in level:
        pre_tree[i].sort(reverse=True)
        post_tree[i].sort(reverse=True)
    
    level = sorted(list(level), reverse=True)
    TREE_DEPTH = len(level)

    preorder = []
    pre_order(MIN, MAX, 0, preorder, pre_tree, level)
    postorder = []
    post_order(MIN, MAX, 0, postorder, post_tree, level)

    return [preorder, postorder]

def pre_order(left, right, depth, result, tree, level):
    if depth == TREE_DEPTH: return
    if len(tree[level[depth]]) <= 0: return
    if not(left < tree[level[depth]][-1][0] < right): return

    x, idx = tree[level[depth]].pop()
    result.append(idx)
    pre_order(left, x, depth+1, result, tree, level)
    pre_order(x, right, depth+1, result, tree, level)

def post_order(left, right, depth, result, tree, level):
    if depth == TREE_DEPTH: return
    if len(tree[level[depth]]) <= 0: return
    if not(left < tree[level[depth]][-1][0] < right): return

    x, idx = tree[level[depth]].pop()
    post_order(left, x, depth+1, result, tree, level)
    post_order(x, right, depth+1, result, tree, level)
    result.append(idx)

nodeinfo = [
    [5,3],[11,5],[13,3],[3,5],[6,1],[1,3],[8,6],[7,2],[2,2]
]
print(solution(nodeinfo))