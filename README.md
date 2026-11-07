# AlgorithmAndDataStructure

> 一个以「一题一文件、随写随跑」方式组织的 Java 算法与数据结构练习仓库：覆盖八大排序、六种查找、经典数据结构、剑指 Offer / LeetCode、牛客 HJ 与华为 OD 真题，以及 LRU / LFU 缓存实现。
>
> 本文档基于对仓库全量源码的逐文件阅读与本机构建实测整理（整理日期：2026-11-07），既是一份导航，也是一份现状评估报告。文中所有路径均相对仓库根目录，`main` 指 `src/main/java`，`test` 指 `src/test/java`。

## 目录

- [1. 项目概览](#1-项目概览)
- [2. 技术栈与工程配置](#2-技术栈与工程配置)
- [3. 快速开始](#3-快速开始)
- [4. 目录结构](#4-目录结构)
- [5. 模块详解](#5-模块详解)
- [6. 复杂度速查表](#6-复杂度速查表)
- [7. 代码风格与约定](#7-代码风格与约定)
- [8. 现状评估与已知问题](#8-现状评估与已知问题)
- [9. 版本控制与忽略规则](#9-版本控制与忽略规则)
- [10. 维护指南](#10-维护指南)
- [11. 作者与许可](#11-作者与许可)

---

## 1. 项目概览

### 1.1 基本信息

| 项目 | 内容 |
| --- | --- |
| Maven 坐标 | `com.weixf:AlgorithmAndDataStructure:1.0`（默认 `jar` 打包） |
| 语言 / 编译目标 | Java，`maven.compiler.source/target = 8`（源码未使用 Java 9+ 特性） |
| 构建工具 | Maven（本机实测 Maven 3.9.6 + JDK 21.0.5 可编译） |
| 第三方依赖 | 仅 `junit:junit:4.13.2`，其余全部使用 JDK 自带类库 |
| 代码组织 | 单一 Maven 模块，`com.weixf` 下按「算法 / 数据结构 / 题源」分包，共 20 个包目录 |
| 远程仓库 | `git@github.com:wxingfu/AlgorithmAndDataStructure.git`（分支 `master`，跟踪 `origin/master`） |
| 提交历史 | 30 次提交，首次 `2021-08-25 Initial commit`，最近 `2024-03-10 20240310` |
| 项目定位 | 个人学习与面试复习代码集，不是可直接引用的算法库；无发布产物、无 CI、无 LICENSE 声明 |

### 1.2 代码规模（按当前工作区统计）

| 指标 | 数值 |
| --- | --- |
| Java 源文件 | **88** 个（`main` 74 个 / `test` 14 个） |
| Java 总行数 | **5430** 行（含空行与注释：`main` 4472 行 / `test` 958 行） |
| 资源文件 | 2 个（`app.properties`、`mark.md`） |
| Git 已跟踪文件 | 93 个（88 个 Java + 2 个资源 + `pom.xml` + `README.md` + `.gitignore`） |
| `public static void main` | **69** 个，全部位于 `main`，即绝大多数类可独立运行 |
| JUnit 测试 | 5 个类、**15** 个 `@Test` 方法（JUnit 4），全部位于 `test` |
| 需要标准输入的类 | 17 个（牛客 11 个 + 华为 OD 6 个），另有 1 个交互式菜单 `HashTable` |
| 中文注释 | 绝大多数文件含中文 Javadoc / 行内注释，部分直接粘贴题目原文与链接 |

### 1.3 内容分布

| 主题 | 包 | 文件数 | 主要内容 |
| --- | --- | --- | --- |
| 排序 / 查找 / 数论 | `algorithm.sort`、`algorithm.search`、`algorithm.other` | 16 | 8 种排序、6 种查找、质数统计 |
| 基础类型与演示 | `base`、`common`、`MyTest` | 5 | 最大公约数、链表/树节点、位运算演示 |
| 经典数据结构 | `datastructure`（main） | 3 | 小顶堆、稀疏数组、二叉树遍历 |
| 剑指 Offer / LeetCode | `leetcode`、`leetcode.sword_finger_offer` | 28 | 21 道剑指 Offer 系列 + 7 道散题 |
| 面试题 | `interview` | 3 | 层序数组建树、链表判环、斐波那契 |
| 牛客 / 华为 OD | `nowcoder`、`nowcoder.huawei_od` | 19 | 字符串、排序、表达式求值、OD 场景题 |
| 缓存与链表树练习 | `test` 下 cache / list / tree / node 等 | 14 | LRU 三种实现、LFU、链表与树的算法演示 |
| 资源 | `src/main/resources` | 2 | 占位属性文件、Java 常量笔记 |

---

## 2. 技术栈与工程配置

`pom.xml` 极简，完整内容仅包含坐标、Java 8 编译参数与一个 JUnit 依赖：

| 配置项 | 当前值 | 说明 / 影响 |
| --- | --- | --- |
| `groupId / artifactId / version` | `com.weixf` / `AlgorithmAndDataStructure` / `1.0` | 固定 `jar` 打包，未配置 `maven-jar-plugin` 主类，产物不可直接 `java -jar` 启动 |
| `maven.compiler.source/target` | `8` | 在 JDK 21 上编译会出现「源值 8 / 目标值 8 已过时」「未设置引导类路径」警告，但可正常编译 |
| `junit:junit:4.13.2` | **未声明 `<scope>test</scope>`** | 默认 `compile`，JUnit 会进入主 classpath 并可能进入最终依赖树；测试代码可正常编译 |
| 编码配置 | 未设置 `project.build.sourceEncoding` | Maven 提示「File encoding has not been set, using platform encoding UTF-8」，在 GBK 环境的机器上中文注释可能乱码 |
| 插件版本 | 未锁定 | 实际使用 `maven-resources-plugin:3.3.1`、`maven-compiler-plugin:3.11.0`、`maven-surefire-plugin:3.2.2`（由 Maven 默认生命周期绑定决定） |
| 其他依赖 | 无 | 算法实现只依赖 `java.util.*`（`Arrays`、`Stack`、`Deque`、`Queue`、`HashMap`、`LinkedHashMap`、`PriorityQueue`、`TreeSet` 等），无第三方算法库 |

---

## 3. 快速开始

### 3.1 环境要求

- JDK 8 及以上（实测 JDK 21.0.5 可用）
- Maven 3.x（实测 3.9.6 可用）
- 首次构建需联网：Maven 会下载插件及 Surefire 的 JUnit4 Provider；离线模式 `mvn -o test` 在 provider 未缓存时报 `surefire-junit4:3.2.2 has not been downloaded`

### 3.2 构建命令

```bash
git clone git@github.com:wxingfu/AlgorithmAndDataStructure.git
cd AlgorithmAndDataStructure

mvn -B compile     # 只编译主源码，最快，推荐用来验证环境
mvn -B package     # 编译 + 测试 + 打 jar（注意当前测试有 1 个报错，见 3.4）
mvn -B test        # 编译并执行 JUnit 测试
mvn -B clean test  # 全新构建
```

### 3.3 运行单个示例

绝大多数类都带 `main`，编译后用全限定类名直接运行：

```bash
mvn -B compile
java -cp target/classes com.weixf.algorithm.sort.QuickSort        # 打印每轮分区结果
java -cp target/classes com.weixf.base.MathBase                   # 输出 6（gcd(120,18)）
java -cp target/classes com.weixf.datastructure.sparsearray.SparseArray  # 11x11 棋盘压缩与还原
java -cp target/classes com.weixf.algorithm.search.HashTable      # 交互式菜单 add/list/find/exit
```

需要标准输入的题目可以直接用管道喂数据（Windows PowerShell 示例）：

```powershell
"abc" | java -cp target/classes com.weixf.nowcoder.StringReverse
"3`na`nc`nb" | java -cp target/classes com.weixf.nowcoder.StringSort
```

> 提示：PowerShell 5.1 管道默认编码可能让中文输出显示为乱码（`chcp 65001` 或改用 IDE 控制台可缓解）；牛客类多用 `while (sc.hasNext())` 支持多组输入，华为 OD 类均为单组输入。

### 3.4 本机构建实测结果

| 命令 | 结果 |
| --- | --- |
| `mvn -o -B test` | 主源码无需重编、14 个测试源码编译成功；因离线缺少 `surefire-junit4:3.2.2` 而 `BUILD FAILURE` |
| `mvn -B test`（联网） | 联网下载 provider 后执行 15 个测试：**14 通过、1 报错**，`BUILD FAILURE` |
| 报错明细 | `ListTest.test7:313 NullPointer Cannot read field "val" because "intersectionNode" is null`——测试用例构造的是两条「值相同但节点不同」的链，`getIntersectionNode` 按引用比较返回 `null`，随后直接取 `.val` 触发 NPE |
| `java -cp target/classes ...` | `QuickSort`、`MathBase`、`StringReverse` 等实测可正常运行并打印结果（见 3.3） |

因此：**编译环节是健康的，测试环节当前不是全绿**。若只想验证编译或运行演示，使用 `mvn -B compile` 即可；如需 `mvn package`，需先修复 `test7` 或使用 `-DskipTests`。

### 3.5 用 IDE 打开

IntelliJ IDEA：`File -> Open` 选择根目录（Maven 项目自动识别），选中某个类右键 `Run 'Xxx.main()'`；带 `Scanner` 的类在 Run 控制台手工输入即可。项目已通过 `.gitignore` 排除 `.idea/`、`*.iml`、`target/` 等本地产物。

---

## 4. 目录结构

```text
AlgorithmAndDataStructure/
├── .gitignore                  # IDE / 构建产物忽略规则
├── pom.xml                     # Maven 配置（Java 8 + JUnit 4.13.2）
├── README.md                   # 本文档
├── src/
│   ├── main/
│   │   ├── java/com/weixf/
│   │   │   ├── MyTest.java                       # 位运算补码演示
│   │   │   ├── base/            MathBase.java   # 最大公约数
│   │   │   ├── common/          ListNode / Node / TreeNode  # 公共节点类型
│   │   │   ├── algorithm/
│   │   │   │   ├── sort/        (8)  BubbleSort, SelectSort, InsertSort, ShellSort,
│   │   │   │   │                   QuickSort, MergeSort, HeapSort, RadixSort
│   │   │   │   ├── search/      (6)  SequenceSearch, BinarySearch, InsertValueSearch,
│   │   │   │   │                   FibonacciSearch, BlockSearch, HashTable
│   │   │   │   └── other/       (2)  CountPrimes, Primes
│   │   │   ├── datastructure/
│   │   │   │   ├── heap/        MinHeap.java
│   │   │   │   ├── sparsearray/ SparseArray.java
│   │   │   │   └── tree/        BinaryTree.java
│   │   │   ├── leetcode/
│   │   │   │   ├── (7)          BinarySearch, CompareVersion, CorpFlightBookings,
│   │   │   │   │               CuttingRope, GetKthFromEnd, MergeTwoLists, SmallestK
│   │   │   │   └── sword_finger_offer/  (21) 剑指 Offer 系列
│   │   │   ├── interview/       (3)  ArrayTree, CheckListLoop, Fib
│   │   │   └── nowcoder/
│   │   │       ├── (13)         字符串 / 数字 / 排序 / 表达式 / 矩阵等 HJ 题
│   │   │       └── huawei_od/   (6)  OD0001 ~ OD0006
│   │   └── resources/           app.properties, mark.md
│   └── test/java/com/weixf/
│       ├── datastructure/
│       │   ├── cache/lru/       LRUCache, LRUCache2, LRUCache3, DLinkedNode, DoubleList
│       │   ├── cache/lfu/       LFUCache
│       │   ├── list/            ListTest（9 个 @Test）
│       │   ├── tree/            TraverseTest（2 个 @Test）
│       │   ├── stack/           StackTest（空壳）
│       │   └── queue/           QueueTest（空壳）
│       ├── interview/           InterviewTest（占位）
│       └── node/                GenericLinkedList, ListNode, TreeNode
└── target/                      # Maven 产物（已忽略）
```

---

## 5. 模块详解

### 5.1 基础与公共类型（5 个文件）

| 文件 | 说明 | 关键 API / 复杂度 | 运行方式 |
| --- | --- | --- | --- |
| `base/MathBase.java` | 递归欧几里得算法求最大公约数，Javadoc 说明 `gcd(a,b)=gcd(b,a mod b)` | `static int gcd(int,int)`，O(log min(a,b)) 时间 / O(log min(a,b)) 栈 | `main` 打印 `gcd(120,18)=6` |
| `common/ListNode.java` | 单链表节点 `val` / `next`，供链表题复用 | 两个构造器，字段 public，无 `toString` | 无 `main` |
| `common/Node.java` | 带 `random` 随机指针的链表节点，用于「复杂链表复制」 | 仅带参构造器 | 无 `main` |
| `common/TreeNode.java` | 二叉树节点 `val` / `left` / `right` | 两个 public 构造器（无参构造器非 public） | 无 `main` |
| `MyTest.java` | 演示 `~` 按位取反、`Integer.toBinaryString` 补码 | 8 行 `println`，无算法 | `main` 直接运行 |

`common` 三个节点类被 11 个题目文件引用：`ListNode`（`GetKthFromEnd`、`MergeTwoLists`、`ReverseList`、`ReversePrintList`）、`TreeNode`（`IsSubStructure`、`IsSymmetric`、`MirrorTree`、`TreeLevelOrder`/`2`/`3`）、`Node`（`CopyRandomList`）。

### 5.2 排序算法 `algorithm.sort`（8 个文件，全部升序）

| 文件 | 实现要点 | 时间 / 额外空间 | 特性与演示 |
| --- | --- | --- | --- |
| `BubbleSort.java` | 4 种变体：基础版、`flag` 提前结束、记录最后交换位置、双向冒泡 | 均 O(n²) / O(1) | 原地、稳定；`main` 用 4 组随机 10 元素数组比较「总交换次数 / 最终排序结果」；中文注释标出 3 处优化点 |
| `SelectSort.java` | 每轮在未排序区选最小值与首位交换 | O(n²) / O(1) | 原地、不稳定；每轮打印数组 |
| `InsertSort.java` | 有序表 + 无序表，元素后移腾位 | O(n²) / O(1) | 原地、稳定；中文 Javadoc 完整，`if (insertIndex+1 != i)` 避免自赋值 |
| `ShellSort.java` | 两种实现：交换法 `shellSort` 与移位插入法 `shellSort2`，增量 `gap = n/2` 折半 | 最坏 O(n²) / O(1) | 原地；`main` 只调用交换法，`shellSort2` 调用被注释 |
| `QuickSort.java` | Hoare 双指针分区，基准取 `arr[(left+right)/2]`，相等时指针强制推进防死循环 | 平均 O(n log n)、最坏 O(n²) / O(log n) 栈 | 原地、不稳定；每轮分区后打印数组 |
| `MergeSort.java` | 递归二路归并，辅助数组 `temp` 由 `main` 创建并传入，`<=` 先取左半 | O(n log n) / O(n) + O(log n) 栈 | 非原地、稳定；每次 merge 后打印数组 |
| `HeapSort.java` | 大根堆：逐个 `heapInsert` 上浮建堆（非 Floyd 自底向下），反复交换堆顶与堆尾后 `heapify` 下沉 | O(n log n) / O(1) | 原地、不稳定；中文注释解释「上浮 / 下降」；固定 5 元素示例 |
| `RadixSort.java` | LSD 最低位优先，10 个桶 `int[10][n]` + `bucketElementCounts[10]` 计数，按最大位数循环 | O(d·n) / O(n) | 非原地，仅支持非负整数；每轮按位处理后打印数组 |

### 5.3 查找算法 `algorithm.search`（6 个文件）

| 文件 | 前置条件 | 核心思路 | 时间 / 空间 | 返回值 |
| --- | --- | --- | --- | --- |
| `SequenceSearch.java` | 无需有序 | 逐个比对 | O(n) / O(1) | 首个匹配下标或 `-1` |
| `BinarySearch.java` | 升序 | 三种写法：递归查单值、递归查**全部重复值**、迭代查单值 | O(log n)（查全部为 O(log n+k)） / O(log n) 或 O(1) | 下标或 `-1`；`binarySearch2` 返回 `List<Integer>`（空表表示未找到） |
| `InsertValueSearch.java` | 升序、分布均匀更佳 | `mid = low + (high-low)*(key-arr[low])/(arr[high]-arr[low])`，递归 + 迭代两版 | 平均 O(log log n)、最坏 O(n) / O(log n) 或 O(1) | 下标或 `-1` |
| `FibonacciSearch.java` | 升序 | 黄金分割查找两套实现：`fibSearch` 用 `Arrays.copyOf` 补长到斐波那契数，`fibonacciSearch` 免复制、越界时用末元素代替 | O(log n) / O(n)（补长版） | 下标或 `-1`；文件头有大段中文原理注释（0.618、`f(k)-1` 划分） |
| `BlockSearch.java` | 索引表升序、块间有序、块内可无序、每块等长 `m` | 先在索引表二分定位块，再块内顺序扫描 | O(log b + m) / O(1) | 原数组下标或 `-1`；`main` 对 `key=0..99` 循环打印 100 行 |
| `HashTable.java` | 无 | 链地址法哈希表：`id % 7` 散列 + 单链表尾插，固定容量 7、无扩容、无删除、添加不查重 | 增删查平均 O(1+n/7) / O(7+n) | `findEmpById` 为 `void`，只打印结果；`main` 提供 `add/list/find/exit` 控制台菜单（`Scanner`，唯一交互式程序） |

### 5.4 其他算法 `algorithm.other`（2 个文件）

| 文件 | 说明 | 复杂度 | 演示 |
| --- | --- | --- | --- |
| `CountPrimes.java` | 埃氏筛变体统计小于 `n` 的质数个数，用 `boolean[] composite` 标记（从 `j=i` 起，非标准 `i*i` 起） | O(n log n) / O(n) | `main` 打印 `countPrimes(10)=4` |
| `Primes.java` | 试除法枚举并打印 `2..n` 全部质数及个数 | O(n√n) / O(1) | `main` 打印 `primes(20)` 的 8 个质数 |

### 5.5 经典数据结构 `datastructure`（3 个文件）

| 文件 | 说明 | 复杂度 | 备注 |
| --- | --- | --- | --- |
| `heap/MinHeap.java` | 小顶堆「尾插上浮」`test1` 与「首尾互换、删尾、首下沉」`test2` 两段手工演示 | 单次 O(log n) / O(n) | 不是完整堆 ADT（无 `insert/peek/poll` 封装）；`main` 只调用 `test2` |
| `sparsearray/SparseArray.java` | 11×11 棋盘二维数组压缩为 `(k+1)×3` 稀疏数组再还原（第 0 行存行列数与非零个数） | O(rows·cols) | 逻辑全在 `main`，用 `printf` 打印矩阵；未做文件存盘/读盘 |
| `tree/BinaryTree.java` | 自建 `BiTree` 节点（7 节点示例树）的前 / 中 / 后序递归遍历 | O(n) / O(h) | 无插入、删除、查找、层序；示例前序 `9,1,3,4,2,5,6` |

### 5.6 LeetCode 散题 `leetcode`（7 个文件）

| 文件 | 对应题目 | 解法 | 复杂度 | 备注 |
| --- | --- | --- | --- | --- |
| `BinarySearch.java` | LC 704 二分查找 | 左右闭区间标准二分 | O(log n) / O(1) | `main` 演示 `nums={5}, target=5` |
| `CompareVersion.java` | LC 165 比较版本号 | `split("\\.")` 逐段 `parseInt`，缺失段补 0 | O(n+m) / O(n+m) | 注释附 leetcode-cn 链接；`main` 为空 |
| `CorpFlightBookings.java` | LC 1109 航班预订统计 | 暴力逐区间累加 `corpFlightBookings` + 差分数组前缀和 `corpFlightBookings2` | 前者最坏 O(n·m) / O(n)，后者 O(n+m) / O(n) | `main` 调用的是暴力版；注释「差分数组」标在了暴力版上 |
| `CuttingRope.java` | 剑指 14-I 剪绳子（近 LC 343） | 自底向上 DP：`dp[i]=max(dp[i], j*(i-j), j*dp[i-j])` | O(n²) / O(n) | `main` 演示 `n=10` |
| `GetKthFromEnd.java` | 剑指 22 链表中倒数第 k 个节点 | 先求长度再定位 + 快慢指针两版 | 均 O(n) / O(1) | 使用 `common.ListNode`；`main` 只打印对象引用 |
| `MergeTwoLists.java` | LC 21 合并两个有序链表 | 递归合并 + 哑节点 `prehead` 迭代尾插 | O(m+n) / O(m+n) 栈 或 O(1) | `main` 演示代码整体被注释 |
| `SmallestK.java` | 面试题 17.14 最小 K 个数 | `Arrays.sort` 全排序后 `System.arraycopy` 取前 k 个（会改动入参） | O(n log n) / O(log n) | 注释附 smallest-k-lcci 链接 |

### 5.7 剑指 Offer 系列 `leetcode.sword_finger_offer`（21 个文件）

文件名即类名，题号依据文件内中文题面 / 链接推断：

| 文件 | 题目 | 核心解法 | 复杂度 | 备注 |
| --- | --- | --- | --- | --- |
| `CQueue.java` | 剑指 09 用两个栈实现队列 | `st1` 入队、`st2` 出队，`st2` 空时整体倾倒；空队列返回 `-1` | 均摊 O(1) / O(n) | 无 `main` |
| `CopyRandomList.java` | 剑指 35 复杂链表的复制（LC 138） | `HashMap<原节点, 新节点>` + 递归回溯同时复制 `next` / `random` | O(n) / O(n) | 使用 `common.Node`；`main` 为空 |
| `FibonacciSequence.java` | 剑指 10-I 斐波那契数列 | DP 数组自底向上，每项对 `1e9+7` 取模 | O(n) / O(n) | `main` 演示 `n=10` |
| `FindNumberIn2DArray.java` | 剑指 04 二维数组中的查找 | 从右上角起步的线性消去法 | O(n+m) / O(1) | `main` 演示 `target=20` |
| `FindRepeatNumber.java` | 剑指 03 数组中重复的数字 | 先 `Arrays.sort` 再扫描相邻相等元素（非原地置换官解） | O(n log n) / O(log n) | 存在 `nums[i+1]` 越界风险，见 8.3 |
| `FirstUniqChar.java` | 剑指 50 第一个只出现一次的字符 | 三实现：26 位计数数组、`HashMap` 频数、`HashMap.replace` 变体 | O(n) / O(1) 或 O(k) | 返回 `char`，不是下标；无结果返回空格 |
| `IsSubStructure.java` | 剑指 26 树的子结构 | 先序遍历 A 的每个节点 + `recurse` 同步匹配 B | O(|A|·|B|) / O(hA+hB) | `main` 为空 |
| `IsSymmetric.java` | 剑指 28 对称的二叉树 | 递归比较 `(A.left,B.right)` 与 `(A.right,B.left)` 镜像对 | O(n) / O(h) | `main` 为空 |
| `MinArray.java` | 剑指 11 旋转数组的最小数字 | 与 `numbers[high]` 比较的二分，相等时 `high--` 去重 | 平均 O(log n)、最坏 O(n) / O(1) | `main` 为空 |
| `MinStack.java` | 剑指 30 包含 min 函数的栈 | 主栈 + 非严格单调递减辅助栈（`Deque`），`min()` 取辅助栈栈顶 | 四操作 O(1) / O(n) | 无 `main` |
| `MirrorTree.java` | 剑指 27 二叉树的镜像 | 递归后序交换左右 + BFS 队列逐节点交换两版 | O(n) / O(h) 或 O(w) | 构造示例树但只打印对象引用 |
| `MissingNumber.java` | 剑指 53-II 0～n-1 中缺失的数字 | 有序数组线性扫描找第一个 `nums[i] > i`（未用二分） | O(n) / O(1) | `main` 演示 `nums={0}` |
| `NumWays.java` | 剑指 10-II 青蛙跳台阶 | 自顶向下记忆化搜索 `long[] memo`，返回时取模 | O(n) / O(n) | `main` 演示 `n=100`，存在 long 溢出，见 8.3 |
| `ReplaceSpace.java` | 剑指 05 替换空格 | `StringBuilder` 逐字符遍历，空格追加 `%20` | O(n) / O(n) | 注释里保留 `s.replace` 备选 |
| `ReverseLeftWords.java` | 剑指 58-II 左旋转字符串 | 生效实现为 `String +=` 循环拼接两段；`substring` / `StringBuilder` / 取余三种更优写法被注释保留 | 生效版 O(n²) / O(n) | `main` 演示 `"lrloseumgh", 6` |
| `ReverseList.java` | 剑指 24 反转链表 | 迭代三指针 `prev/curr/next` 原地改指针 | O(n) / O(1) | `main` 为空 |
| `ReversePrintList.java` | 剑指 06 从尾到头打印链表 | 两次遍历：先求长度，再正向遍历倒序填充数组（非栈 / 递归） | O(n) / O(n) | `main` 构造了多余哑头节点 |
| `SearchNumInArrCount.java` | 剑指 53-I 排序数组中查找数字 I | 线性计数 + 两次二分找左右边界（`lower` 参数）两版 | O(n) 或 O(log n) / O(1) | `main` 调用线性版 |
| `TreeLevelOrder.java` | 剑指 32-I 从上到下打印二叉树 | BFS 队列，**扁平一维** `int[]`，不分层 | O(n) / O(n) | `main` 为空 |
| `TreeLevelOrder2.java` | 剑指 32-II（LC 102） | BFS 逐层分组：`for (i = queue.size(); i > 0; i--)`，返回 `List<List<Integer>>` | O(n) / O(n) | `main` 为空 |
| `TreeLevelOrder3.java` | 剑指 32-III（LC 103） | BFS 逐层分组 + 之字交替，用 `LinkedList` 的 `addLast` / `addFirst` 控制层内方向 | O(n) / O(n) | `main` 构造 `[3,9,20,null,null,15,7]` 并打印 `[[3],[20,9],[15,7]]`；方向注释与代码相反 |

**层序三兄弟差异**：`TreeLevelOrder` 返回扁平 `int[]`（`[3,9,20,15,7]`）→ `TreeLevelOrder2` 逐层分组（`[[3],[9,20],[15,7]]`）→ `TreeLevelOrder3` 在分组基础上逐层反转方向（`[[3],[20,9],[15,7]]`）。三者分别是 `static` / 实例 / `static` 方法，签名风格不统一。

### 5.8 面试题 `interview`（3 个文件）

| 文件 | 说明 | 复杂度 | 备注 |
| --- | --- | --- | --- |
| `ArrayTree.java` | 由层序数组 `Integer[]`（`null` 占位）用队列逐层构建二叉树，文件内自带包级 `TreeNode` | O(n) / O(n) | 注释承诺「并且遍历输出」但未实现，`main` 为空 |
| `CheckListLoop.java` | **Floyd 快慢指针**判断链表是否有环（slow 一步、fast 两步），文件内自带包级 `Node` | O(n) / O(1) | `main` 中成环语句被注释，演示输出 `false` |
| `Fib.java` | 三实现：朴素递归（限 `0..30`）、滚动变量迭代取模 `1e9+7`、`fib3` | 递归 O(2ⁿ) / O(n) 栈；迭代 O(n) / O(1) | `fib3` 误调 `fib(...)`，语义与 `fib2` 不一致 |

另有 `test/interview/InterviewTest.java` 为占位测试，不覆盖这三个类。

### 5.9 牛客 HJ 系列 `nowcoder`（13 个文件）

除 `ValidBrackets`、`Calculate` 为硬编码自测外，其余均用 `Scanner(System.in)`；10 个类通过 `while (sc.hasNext())` / `hasNextLine()` 支持多组输入，`DecAndHexOctal` 只处理单行。

| 文件 | 功能 | 输入 → 输出 | 关键做法 |
| --- | --- | --- | --- |
| `StringReverse.java` | 整行字符串整体反转 | 每行文本 → 反转后的整行 | `StringBuilder.reverse()` |
| `WordReverse.java` | 单词倒排（词序逆序，非字母当分隔符） | 每行文本 → 逆序单词、单空格分隔 | `replaceAll("[^A-Za-z]", " ")` + `split` |
| `TextReverse.java` | 每个单词自身字符反转，词序不变 | 每行文本 → 逐词反转后拼接 | 按空格切词 + `StringBuilder.reverse()` |
| `StringSort.java` | n 个字符串按字典序排序 | 首行 n + n 行字符串 → 排序后 n 行 | `Arrays.sort` |
| `NumStringSort.java` | 空格分隔数字串：奇数位升序、偶数位降序后按原位置交错 | 一行数字串 → 重排行 | 奇偶分装 `Integer[]` + `Arrays.sort` / `reverseOrder` |
| `NumReverse.java` | 整数以字符串形式逆序输出（`100` → `001`） | 一个 int → 逆序数字串 | 倒序拼接字符 |
| `DecAndHexOctal.java` | 十六进制串 → 十进制，再把同一数值转回十六进制 | 单行 `0x...` → 两行：十进制、十六进制串 | 手写 `A~F` 查表 + `Math.pow(16, k)`；类名含 Octal 但无八进制逻辑 |
| `ValidBrackets.java` | 有效括号校验（LC 20 题型），两解并列 | 硬编码 `"(]"` 与 `"{[]}"` → `false` / `true` | `String.replace` 消消乐 O(n²) 与 `Stack<Character>` 压期望右括号 O(n) |
| `Calculate.java` | 简易四则运算（无括号、仅个位数） | 硬编码 `1+4*5-8/3` → `19` | 数字栈 + 运算符栈，`*`/`/` 即时计算 |
| `Compute.java` | 带 `{} [] ()` 括号、多位数、`+ - * /` 的表达式求值 | 每行一个表达式 → int 结果 | 递归下钻括号 + 减法转负数入栈；`static int pos` 多组输入未重置 |
| `SnakeMatrix.java` | 输出 n 阶上三角蛇形矩阵 | 一个 n → n 行数字 | 等差数列递推，不建数组，O(n²)/O(1) |
| `DataClassify.java` | 数据分类处理：规则 R 去重升序，找 I 中十进制串连续包含 R 的项 | 两行（I 序列、R 序列）→ 命中总数及各 R 的 (索引, 值) | `TreeSet` + `indexOf` 子串匹配 |
| `StringSplit.java` | 字符串按长度 8 拆分，不足补 `0` | 每行文本 → 若干 8 字符行 | `substring` + 末段补零；唯一用 `hasNextLine()` 的类 |

### 5.10 华为 OD `nowcoder.huawei_od`（6 个文件）

编号 `OD0001`~`OD0006` 是仓库自定义序号，非官方题号；Javadoc 均附 CSDN 参考链接。6 个类全部 `Scanner(System.in)` 单组输入、全部带 `main`。

| 文件 | 题目 / 功能 | 输入 → 输出 | 算法 |
| --- | --- | --- | --- |
| `OD0001.java` | 羊、狼、农夫过河求最少运输次数 | 单行 `M N X`（羊数、狼数、船容量）→ 最少次数，无解输出 `0` | DFS 回溯枚举每次运 i 只羊 + j 只狼，约束「任一岸羊数为 0 或 羊 > 狼」，指数级、无记忆化 |
| `OD0002.java` | 求单向链表的中间节点 | 首行「头地址 节点数」，随后 N 行「地址 值 next 地址」→ 中间节点值 | `HashMap<Integer,ListNode>` 模拟地址到节点，先求长度再走 `size/2` |
| `OD0003.java` | 最大化控制资源成本（区间任务叠加求可共用的最大资源数） | 首行任务数，随后每行 `a b c` → 一个整数 | 区间按左端排序后两两求交并累加权重，迭代到集合收敛 |
| `OD0004.java` | 区间连接器（用给定长度连接器把离散区间连成尽量少的段） | 第一行区间串如 `[1,3],[5,7]`，第二行连接器长度串如 `[2,4]` → 剩余段数 | 区间排序合并 → 计算间隙 → 间隙与连接器双排序后贪心双指针匹配 O(n log n) |
| `OD0005.java` | 水库蓄水（代码实为最大盛水面积 / 最大矩形） | 单行空格分隔高度数组 → 两行：最大面积、取得时的左右下标 | 双指针向中间收缩 O(n)/O(1) |
| `OD0006.java` | 上班之路：网格在「转弯次数 ≤ t、路障数 ≤ c」约束下 S→T 是否可达 | 首行 `t c n m`，随后 n 行 m 字符地图 → `YES` / `NO` | DFS 四方向回溯 + 走过标记与失败分支恢复，最坏 O(4^(n·m)) |

### 5.11 测试目录 `src/test/java`（14 个文件）

这里既有真正带 `@Test` 的演示类，也有**放在 test 目录但没有测试、也没有 main** 的缓存实现与节点类——后者既不会打进主 `jar`，也不会被 `mvn test` 执行，只能通过 IDE 或被其它类引用来使用。

#### 缓存实现（6 个，无 `@Test`、无 `main`）

| 文件 | 实现 | 复杂度 |
| --- | --- | --- |
| `cache/lru/LRUCache.java` | `HashMap<Integer,DLinkedNode>` + 手写 `DoubleList`（head/tail 哨兵），尾部最近使用 | `get/put` O(1) / O(capacity) |
| `cache/lru/LRUCache2.java` | 组合 `LinkedHashMap`（插入顺序），`get` 时 `remove` 再 `put` 手动搬到队尾，淘汰 `keySet().iterator().next()` | O(1) / O(capacity) |
| `cache/lru/LRUCache3.java` | 继承 `LinkedHashMap` 并开启 `accessOrder=true`，重写 `removeEldestEntry` 自动淘汰 | O(1) / O(capacity)，代码最少；类非 public |
| `cache/lru/DLinkedNode.java` | 双向链表节点 `key/val/prev/next` | O(1) |
| `cache/lru/DoubleList.java` | 带哨兵的双向链表：`addLast` / `remove` / `removeFirst` / `size` | O(1)；`addLast` 有断链缺陷（见 8.3） |
| `cache/lfu/LFUCache.java` | 三张表 `keyToVal` / `keyToFreq` / `freqToKeys(LinkedHashSet)` + `minFreq`，同频次内按 LRU 淘汰 | `get/put` O(1) / O(capacity) |

**LRU 三实现对比**：`LRUCache` 自己维护哈希 + 双向链表；`LRUCache2` 借 `LinkedHashMap` 容器但仍手动搬节点；`LRUCache3` 完全交给 JDK 的访问顺序机制。`LFUCache` 是「双哈希 + 频次桶 + minFreq」的经典 O(1) 方案。

#### 带 `@Test` 的类（5 个，共 15 个方法）

| 文件 | `@Test` 数 | 实际内容 |
| --- | --- | --- |
| `datastructure/list/ListTest.java` | 9 | 最丰富：合并两个有序链表、优先队列合并 K 个有序链表、找/删倒数第 k 个、找中点、Floyd 判环与找环入口、求链表交点、删除排序链表重复值；全部硬编码构造 + `System.out` 打印，**无任何断言**；`test7` 当前报错（见 3.4） |
| `datastructure/tree/TraverseTest.java` | 2 | 带层号的 DFS 前序、后序统计节点数、最大深度、直径、BFS 层序、BFS 最小深度；打印 `maxDepth` / `diameter` / `minDepth`，无断言 |
| `datastructure/stack/StackTest.java` | 1 | 空壳，方法体为空 |
| `datastructure/queue/QueueTest.java` | 1 | 空壳（方法名暗示环形队列，未实现） |
| `interview/InterviewTest.java` | 2 | 打印 `Integer[]` 对象引用 + 一个空方法，几乎无内容 |

#### 节点 POJO（3 个，非测试类）

`node/ListNode.java`（供 `ListTest`）、`node/TreeNode.java`（供 `TraverseTest`）、`node/GenericLinkedList.java`（声明了泛型 `E` 但 `value` 写死 `String`，且无 `add/remove/遍历`，明显未完成）。注意这里的 `ListNode` / `TreeNode` 与 `main` 的 `common` 包、以及 `OD0002` 内部自定义节点是**不同的类**。

### 5.12 资源文件

| 文件 | 内容 | 是否被代码引用 |
| --- | --- | --- |
| `src/main/resources/app.properties` | 仅一行 `aaa=bbbb3542`，占位性质 | 否（全仓库无 `Properties` / 文件读取代码） |
| `src/main/resources/mark.md` | 6 行 Markdown 笔记：Java 常量（整型常量默认 `int`、浮点型常量默认 `double`） | 否，纯学习备忘 |

---

## 6. 复杂度速查表

### 6.1 排序

| 算法 | 平均时间 | 最坏时间 | 额外空间 | 稳定性 | 是否原地 | 本仓库实现特点 |
| --- | --- | --- | --- | --- | --- | --- |
| 冒泡（4 变体） | O(n²) | O(n²) | O(1) | 稳定 | 是 | flag / 最后交换位置 / 双向三种优化并存 |
| 选择 | O(n²) | O(n²) | O(1) | 不稳定 | 是 | 每轮选最小值 |
| 插入 | O(n²) | O(n²) | O(1) | 稳定 | 是 | 元素后移腾位 |
| 希尔 | O(n log n)~O(n²) | O(n²) | O(1) | 不稳定 | 是 | `gap=n/2` 折半，交换法 + 移位法 |
| 快排 | O(n log n) | O(n²) | O(log n) | 不稳定 | 是 | 中间值基准 + Hoare 双指针 |
| 归并 | O(n log n) | O(n log n) | O(n) | 稳定 | 否 | 外部 `temp` 数组由调用方传入 |
| 堆排 | O(n log n) | O(n log n) | O(1) | 不稳定 | 是 | 上浮建堆（非 Floyd O(n) 建堆） |
| 基数（LSD） | O(d·n) | O(d·n) | O(n) | 稳定 | 否 | 10 桶 + 计数数组，仅非负整数 |

### 6.2 查找

| 算法 | 前置条件 | 平均 / 最坏时间 | 空间 | 返回语义 |
| --- | --- | --- | --- | --- |
| 顺序查找 | 无 | O(n) / O(n) | O(1) | 下标或 `-1` |
| 二分查找 | 升序有序 | O(log n) / O(log n) | 递归 O(log n)、迭代 O(1) | 下标或 `-1`；查全部重复值返回 `List` |
| 插值查找 | 升序有序且尽量均匀 | O(log log n) / O(n) | 递归 O(log n)、迭代 O(1) | 下标或 `-1` |
| 斐波那契查找 | 升序有序 | O(log n) / O(log n) | O(n)（补长版）或 O(log n) | 下标或 `-1` |
| 分块查找 | 索引表有序、块间有序、块内可无序 | O(log b + m) | O(1) | 下标或 `-1` |
| 哈希查找 | 无 | 平均 O(1)、最坏 O(n) | O(容量 + n) | 打印查找结果（`void`） |

---

## 7. 代码风格与约定

1. **一题一文件、静态工具方法 + `main` 自测**：69 个 `main` 全在 `src/main/java`；多数类只有 `static` 方法，无接口、无统一 API 契约；`levelOrder` 在三个类中分别是 `static` / 实例 / `static`。
2. **演示数据硬编码或随机生成**：排序多为 `new int[10]` + `Math.random()`；查找用 1..100 或固定有序数组；每轮常打印 `Arrays.toString(arr)` 展示中间过程；无 `currentTimeMillis` 计时、无大规模压测、无文件 IO。
3. **一题多解是主要学习方式**：至少 11 个类同时保留自写版与标注「官解」的优化版（差分数组、快慢指针、两次二分、HashMap 复制链表等），部分更优解被注释保留，但 `main` 常调用性能较差的那一版。
4. **注释以中文为主**：`algorithm` 包 16 个文件全部含中文思路注释，题目类常直接粘贴题干、示例与 leetcode-cn / CSDN 链接；少数文件（`CopyRandomList`、`CheckListLoop`）无中文注释。
5. **节点类型分散**：`common`（main，供题目复用）、`node`（test，供测试复用）、题目文件内包级类（`ArrayTree`、`CheckListLoop`、`BinaryTree` 的 `BiTree`、`OD0002` 的内部 `ListNode`）三套并存；均缺 `toString`，因此部分 `main` 只打印对象地址。
6. **IO 契约**：牛客类以 `Scanner(System.in)` 为主，多数 `while (sc.hasNext())` 支持多组；华为 OD 类全部单组输入；`Scanner` 均未 `close()`；`HashTable` 是唯一交互式菜单程序，`exit` 调用 `System.exit(0)`。
7. **静态可变状态较多**：`Compute.pos`、`OD0001.min_times`、`OD0003.max_machine`、`OD0006` 的静态 `map/t/c/n/m`、`TraverseTest.maxDiameter` 等，使这些类不可重入。
8. **无自动化校验**：全仓库 `assert` / `Assert.*` 命中 0 处；15 个 `@Test` 方法只做打印或空实现（唯一报错来自无意的 NPE，而非断言失败）。

---

## 8. 现状评估与已知问题

> 本节为静态审查 + 本机构建实测结论，**仅记录，未改动任何源码**。部分条目已抽样核对源文件，其余来自逐文件阅读。

### 8.1 值得保留的优点

- 覆盖面广：从八大排序、六种查找、堆/稀疏数组/树，到剑指 Offer、牛客 HJ、华为 OD、LRU/LFU 缓存，适合按主题复习。
- 几乎每个类都能单独跑，中文注释与题目原文完整，便于对着输出理解算法的每一步（尤其排序的逐轮打印）。
- 大量「自写版 + 官解版」对照，直观体现从暴力到优化的演进路径。
- 零第三方算法依赖，代码均为手写实现，clone 后只需 Maven 即可编译。

### 8.2 工程化现状

| 问题 | 影响 | 建议 |
| --- | --- | --- |
| `junit` 未声明 `<scope>test</scope>` | JUnit 进入主 classpath / 依赖树 | 补上 `test` scope |
| 未设置 `project.build.sourceEncoding` | 不同系统编码下中文注释可能乱码，构建提示 platform dependent | 固定 `UTF-8` |
| 未锁定 Surefire / 编译器插件版本 | 不同 Maven 版本行为不一致；首次离线构建必失败 | 在 `pom.xml` 显式声明插件版本 |
| `mvn -B test` 当前 `BUILD FAILURE` | 15 个测试中 `ListTest.test7` NPE，`mvn package` 亦会失败 | 修正用例（让两条链真正相交）或加空值判断 |
| 测试零断言、3 个测试类近乎空壳 | 恒绿但无回归能力，缓存类完全无覆盖 | 为排序/查找/缓存补参数化断言 |
| 缓存实现放在 `src/test/java` 且无 `@Test`/`main` | 既不打包也不执行，无法直接运行 | 迁到 `src/main/java` 或补测试 |
| 无 CI、无 LICENSE | 无法自动验证、复用边界不清 | 补 GitHub Actions 与许可文件 |

### 8.3 审查发现的代码风险（按模块）

| 模块 / 位置 | 现象 | 影响 |
| --- | --- | --- |
| `leetcode/sword_finger_offer/FindRepeatNumber.java` | 循环 `i < nums.length` 内访问 `nums[i+1]` | 无重复或重复在末位时数组越界（已核对源码） |
| `leetcode/sword_finger_offer/NumWays.java` | `memo[i]` 存未取模的两项和，仅返回时取模 | `main` 演示 `n=100` 时 `long` 溢出，结果错误（已核对源码） |
| `test/.../cache/lru/DoubleList.java` | `addLast` 中 `x.next = head`（应为 `tail`），哨兵闭环被破坏 | `LRUCache` 淘汰/搬节点时结构错乱，`removeFirst()` 空表返回 `null` 还会 NPE（已核对源码） |
| `algorithm/sort/HeapSort.java` | `heapify` 先访问 `arr[right]` 再判断 `right < size` | 右子节点越界时抛异常 |
| `algorithm/sort/BubbleSort.java` | `bubbleSort2` 同时收缩 `len=idx` 与 `j<len-i`；`bubbleSort3` 反向段无条件循环右移 | 可能提前结束 / 破坏有序，两个优化版结果不可靠 |
| `algorithm/search/BlockSearch.java` | 块内循环未校验 `j < array.length` | 最后一块不足 `m` 时越界 |
| `algorithm/search/InsertValueSearch.java` | `(arr[high]-arr[low])` 为 0 时除零 | 全等值数组 + 命中值触发 `ArithmeticException`；乘积还可能 int 溢出 |
| `algorithm/sort/RadixSort.java` | 直接以位值作桶下标、取 `arr[0]` 求最大值 | 不支持负数与空数组 |
| `algorithm/search/FibonacciSearch.java` | `maxSize = 20` 固定、`copyOf` 长度与注释 `f(k)-1` 不一致 | 超长数组受限 |
| `datastructure/heap/MinHeap.java` | `test1` 在 `a>=b` 时不更新 `idx`；`test2` 下沉边界用 `<=` 且未比较父子 | 可能死循环 / 越界，非通用堆实现 |
| `datastructure/sparsearray/SparseArray.java` | 内层循环用 `OriginChess.length` 而非 `OriginChess[i].length` | 仅方阵正确 |
| `datastructure/tree/BinaryTree.java` | 三个遍历方法未判 `root == null` | 空树 NPE |
| `nowcoder/Compute.java` | `static int pos` 每组输入间不重置 | 多组输入时第二组起被跳过 |
| `nowcoder/DecAndHexOctal.java` | 回转换值循环条件 `%16 > 0`、低位先 append 未整体反转 | 16 的倍数提前终止、结果逆序 |
| `nowcoder/Calculate.java` | 仅识别个位数字，连续减法受栈 LIFO 影响 | `1-2-3` 等表达式结果错误 |
| `nowcoder/huawei_od/OD0006.java` | 转弯判断 `ints[0] != x && ints[1] != y` 对相邻格恒假 | 转弯次数约束失效 |
| `nowcoder/huawei_od/OD0003.java` | 比较器 else 分支写成 `o1.get(1) - o2.get(2)`（索引 2 是权重） | 排序语义错误 |
| `nowcoder/huawei_od/OD0002.java` | `while (head.next != -1)` 不访问尾节点 | `size==1` 或中间节点为尾时无输出 |
| `leetcode/sword_finger_offer/ReversePrintList.java` | `main` 造了 `val=0` 的哑头节点参与打印 | 演示输出 `[2,3,1,0]` 与题面不符（算法本身正确） |
| `leetcode/CorpFlightBookings.java`、`TreeLevelOrder3.java`、`interview/Fib.java` 等 | 注释与实现错位（差分注释标在暴力版、之字方向写反、`fib3` 误调 `fib`） | 阅读时易被误导 |
| `leetcode/.../CompareVersion.java`、`MinArray.java`、`FibonacciSequence.java` 等 | 缺边界防护（超 int 修订号、空数组、负数 n） | 特定输入抛异常 |
| 多个类的 `main` | 10 余个 `main` 为空或演示代码被注释；链表/树类只打印对象地址 | 运行后看不到有效输出 |

### 8.4 建议的改进顺序（供后续迭代，本次未实施）

1. **P0**：修复 `ListTest.test7` 让 `mvn test` 全绿；`junit` 补 `test` scope；补 `sourceEncoding`。
2. **P1**：修复 8.3 中已确认的越界 / 溢出 / 断链 / 除零问题（`FindRepeatNumber`、`NumWays`、`DoubleList`、`HeapSort`、`BlockSearch`、`InsertValueSearch`）。
3. **P2**：给排序、查找、LRU/LFU 补带断言的单元测试；统一静态/实例方法签名与节点类型；为 `common` 节点补 `toString`；将缓存实现迁入 `main` 或补测试。
4. **P3**：引入 CI（自动跑 `mvn -B test`）、补 LICENSE、把「已知问题」逐条关闭后转为正式的算法库说明。

---

## 9. 版本控制与忽略规则

`.gitignore` 按用途分组，覆盖 IDE 元数据、构建产物、临时文件与系统文件：

| 规则组 | 规则 | 作用 |
| --- | --- | --- |
| IntelliJ IDEA | `.idea/`、`*.iml`、`*.ipr`、`*.iws`、`out/`、`gen/` | 忽略 IDE 工程配置、模块文件与 IDE 编译输出 |
| Eclipse / VS Code | `.classpath`、`.project`、`.settings/`、`.factorypath`、`.vscode/` | 兼容其它 IDE 打开时生成的元数据 |
| Maven / 编译产物 | `target/`、`*.class`、`*.log` | 忽略整个 Maven 输出目录及散落的字节码、日志 |
| 临时文件 | `*.tmp`、`*.bak`、`*~` | 忽略编辑器临时/备份文件 |
| 操作系统 | `.DS_Store`、`Thumbs.db` | 忽略 macOS / Windows 资源管理器文件 |

当前工作区实际存在 `.idea/`（含 `workspace.xml`、`misc.xml` 等）与 `target/`（`classes`、`test-classes`、`maven-status`、`surefire-reports` 等），二者**均未被 Git 跟踪**（93 个已跟踪文件全部是源码 / 配置 / 文档）。可用下列命令验证忽略是否生效：

```bash
git status --short
git check-ignore -v .idea/workspace.xml target/classes demo.iml
```

---

## 10. 维护指南

新增一道题或一种算法时，建议沿用现有组织方式：

1. 按题源放入对应包：经典算法 → `algorithm.*`，数据结构 → `datastructure.*`，剑指 Offer → `leetcode.sword_finger_offer`，LeetCode → `leetcode`，牛客 → `nowcoder`，OD → `nowcoder.huawei_od`。
2. 一个类一个主题；需要复用节点时优先引用 `com.weixf.common`，不要再造一套同名类。
3. 类注释写明题目原文 / 链接 / 示例；核心方法写清思路与复杂度；保留「自写版 + 优化版」时注明哪个是生效实现。
4. 提供 `main` 自测或 `@Test` 断言（推荐断言）；带 `Scanner` 的类在注释里写明输入格式与是否支持多组输入。
5. 提交前执行 `mvn -B compile`（或 `mvn -B test`，需先修复 3.4 的失败用例），并确认 `git status --short` 中没有 `.idea/`、`target/`、`*.iml` 等本地产物。

---

## 11. 作者与许可

- 源码类注释署名 `wxf`，仓库归属 GitHub 用户 `wxingfu`。
- 仓库**未包含 LICENSE 文件**，也未在 `pom.xml` 中声明许可信息；如需开源复用，请先补充许可声明。
- 本项目为个人学习记录，代码以演示算法思路为目的，不保证边界完备性与生产可用性；已知问题见 [第 8 节](#8-现状评估与已知问题)。
