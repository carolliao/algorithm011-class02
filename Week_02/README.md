学习笔记

1、哈希表

​		1-1、什么是叫哈希表

​				通过键值对key－value进行访问的数据结构，哈希表也叫散列表，融合了数组和链表的特性

​		1-2、特点

   			数组(顺序表)：寻值容易，根据索引值找到值

  			链表：插入删除容易

  			哈希表：寻址容易，插入和删除也容易

​		1-3、哈希表的思想

   			散列表 ＋ 散列函数

   			散列表以哈希值为索引的数组

   			散列函数：可以根据值(value)求出哈希值key的函数

​		1-4、哈希冲突

  			  同一个哈希值对应多个value，

​				解决办法：开放寻址和拉链法

​				解决的一个办法：数组＋链表 数组对应哈希值，链表存放value

​				jdk1.8之前，数组＋链表

​				jdk1.8之后，数组＋链表＋红黑树

​				数组的索引值通过哈希函数来获取，因此哈希函数如果设计的好的话，就会减少哈希冲突的概率，使存		储的key相对分散，不会形成很长的链表而引起查询的时间复杂度变高

​		

​	    算法题：

​		(a) 利用HashMap进行字母异位相关操作

​				核心思想：找到字符或字符串转换成HashMap的Key的方法

​		

2、映射

3、集合

4、树

​		4-1、遍历----->深度优化遍历和广度优先遍历

​		4-2、深度优先遍历：前序遍历、中序遍历和后序遍历

​			4-2-1、前序遍历：取根节点-->遍历左节点-->遍历右节点

​						（a）递归实现：				

```java
void preorderTraversal(TreeNode node){
    if(node == null){
    	return;
	}
	int value = node.value;
	preorderTraversal(node.leftChild);
	preorderTraversal(node.rightChild);
}

```

​						（b）迭代实现：取值，得左节点，左节点边遍历边取值入栈，左节点为null，出栈，得右节点

```
void preorderTraversal(TreeNode node){
	List<Integer> values = new ArrayList<>();
	TreeNode treeNode = node;
	Deque<TreeNode> stack = new ArrayDeque<>();
	while(treeNode != null || !stack.isEmpty()){
		//2、遍历左节点
		while(treeNode != null) {
			//1、取出根节点值
			values.add(treeNode.value);
			stack.addLast(treeNode);
			treeNode = treeNode.leftChild;
		}
		//左节点遍历完之后，检查每个节点下的右节点，如果存在继续遍历
		if(!stack.isEmpty()){
			TreeNode n = stack.pollLast();
			//3、遍历右节点，它会回到步骤2遍历该节点的左节点
			treeNode = n.rightChild;
		}
	}
}

void preorderTraversal(TreeNode node){
	List<Integer> values = new ArrayList<>();
	Deque<TreeNode> stack = new ArrayDeque<>();
	stack.addLast(node);
	while(!stack.isEmpty()){
		TreeNode treeNode = stack.pollLast();
		//出栈，取值
		values.add(treeNode.value);
		//右子节点入栈
		if(treeNode.rightChild != null){
			stack.addLast(treeNode.rightChild);
		}
		//左子节点入栈
		if(treeNode.leftChild != null){
			stack.addLast(treeNode.leftChild);
		}
	}
}
```

​            4-2-2、中序遍历：遍历左节点--->取根节点-->遍历右节点

​						（a）递归实现：左节点遍历入栈，左节点为null出栈，先取值，再得右节点

```
void inorderTraversal(TreeNode node){
	if(node == null){
		return;
	}
	inorderTraversal(node.leftChild);
	int value = node.value;
	inorderTraversal(node.rightChild);
}
```

​						（b）迭代实现：

```
void inorderTraversal(TreeNode node){
	List<Integer> values = new ArrayList<>(); 
	TreeNode treeNode = node;
	Deque<TreeNode> stack = new ArrayDeque<>();
	while(treeNode != null || !stack.isEmpty()){
		//1、遍历左节点
		while(treeNode != null){
			stack.addLast(treeNode);
			treeNode = treeNode.leftChild;
		}
		
		if(!stack.isEmpty()){
			//2、左节点为null，出栈，取出根节点值
			TreeNode n = stack.pollLast();
			values.add(n.value);
			//3、遍历右节点，它会回到步骤1遍历该节点的左节点
			treeNode = treeNode.rightChild;
		}
	}
}

```

​			4-2-3、后序遍历：遍历左节点--->遍历右节点--->取根节点

​						（a）递归实现：

```
void postOrderTraversal(TreeNode node){
	if(node == null){
		return;
	}
	postOrderTraversal(node.leftChild);
	postOrderTraversal(node.rightChild);
	int value = node.value;
}
```

​						（b）迭代实现：左节点遍历入栈，左节点为null出栈，得到右节点，右节点为null则取值

```
void postOrderTraversal(TreeNode node){
	List<Integer> values = new ArrayList<>();
	TreeNode treeNode = node;
	Deque<TreeNode> stack = new ArrayDeque<>();
	while(treeNode != null || !stack.isEmpty()){
		//1、遍历左节点
		while(treeNode != null){
			stack.addLast(treeNode);
			treeNode = treeNode.leftChild;
		}
		//2、遍历右节点，它会回到步骤1遍历该节点的左节点
		TreeNode n = null;
		if(!stack.isEmpty()){
			n = stack.pollLast();
			treeNode = n.rightChild;
		}
		//检查右节点是否为null
		if(treeNode == null && n != null){
			//3、取出根节点的值
			values.add(n.value);
		}
	}
}

//适应N叉数的后序遍历(只需将子节点入栈那里改成for循环即可)
void postOrderTraversal(TreeNode node){
	List<Integer> values = new ArrayList<>();
	Deque<TreeNode> stack = new ArrayDeque<>();
	stack.addLast(node);
	while(!stack.isEmpty()){
		TreeNode treeNode = stack.pollLast();
		values.add(0, treeNode.value);
		
		if(treeNode.leftChild != null){
			stack.addLast(treeNode.leftChild);
		}
		
		if(treeNode.rightChild != null){
			stack.addLast(treeNode.rightChild);
		}
	}
	
}
```

​        4-3、广度优先遍历

​				4-3-1、层序遍历：从左到右，逐层遍历

​						实现方式：基于队列的方式实现

```
public void levelOrderTraversal(Node root, List<Integer> result){
        if(root == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node node = queue.poll();
            result.add(node.val);
            //把该节点对应的最节点一次放入队列中
            queue.addAll(node.children);
        }
}


/**
     * 基于队列的方式遍历并按层级进行分组
     * 核心点：怎么判断层级？
     * @param root
     * @param result
     */
public void levelOrderTraversal1(Node root, List<List<Integer>> result){
    if(root == null){
    	return;
    }

    Queue<Node> queue = new LinkedList<>();
    queue.add(root);
    while(!queue.isEmpty()){
        List<Integer> level = new ArrayList<>();
        //记下当前队列中的元素个数，这个个数代表当前层级上的节点个数
        int size = queue.size();
        for(int i = 0; i < size; i++){
            Node node = queue.poll();
            level.add(node.val);
            //把该节点对应的最节点一次放入队列中
            queue.addAll(node.children);
        }
        result.add(level);
    }
}        
```





5、堆

​	5-1、什么是堆

​			可以快速从大量的数据中找到最大值或最小值的一种数据结构。这种数据结构可以使用数组来实现，比如PriorityQueue就是一种堆结构。

​			根节点的值是最大值的叫做大根堆，跟节点的值是最小值的叫做小根堆。

​			常见的堆有二叉堆、斐波拉契堆等。

​			堆的实现代码：https://shimo.im/docs/Lw86vJzOGOMpWZz2/

​			不同实现的比较：https://en.wikipedia.org/wiki/Heap_(data_structure)

​			![image-20200703214034208](D:\workspace\github\GeekBang\algorithm011-class02\Week_02\images\各种堆的复杂度比较.png)

​			时间复杂度：

​			查询最大O(1) 删除最大O(logN)  插入O(logN) 或O(1) 

​	5-2、二叉堆

​				通过完全二叉树来实现。注意，不是二次搜索树

​				二叉堆(大根堆)的特性：

​				一、是一个完全树

​				二、树中任意节点的值重视>=其子节点的值

6、图

​		6-1、什么是图

​				一颗树中存在闭环。有节点和边线

​				数学表示法：Graph(V, E)

​				V--vertex:点

​						(a) 度 出度和入度 当边有向时可以区分入度和出度

​						(b) 点与点之间连通与否

​				E--edge:边

​						(a)有向(箭头线)和无向(单行线)

​						(b) 权重(边长)

​		6-2、图怎么表示

​				临接表和临接矩阵

​			![image-20200703215950864](D:\workspace\github\GeekBang\algorithm011-class02\Week_02\images\图的实际数据结构.png)

​	6-2、图的分类

​			无向无权图

![image-20200703215950864](D:\workspace\github\GeekBang\algorithm011-class02\Week_02\images\无向无权图.png)

​			无向有权图

![image-20200703220819031](D:\workspace\github\GeekBang\algorithm011-class02\Week_02\images\无向有权图.png)

​			有向无权图

![image-20200703220649915](D:\workspace\github\GeekBang\algorithm011-class02\Week_02\images\有向无权图.png)

​			有向有权图

![image-20200704222224166](D:\workspace\github\GeekBang\algorithm011-class02\Week_02\images\有向有权图.png)

6-3、基于图的常见算法

![image-20200703221305319](D:\workspace\github\GeekBang\algorithm011-class02\Week_02\images\深度优先递归写法模板.png)

![image-20200703221430786](D:\workspace\github\GeekBang\algorithm011-class02\Week_02\images\广度优先递归算法模板.png)