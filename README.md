# CustomDialog
继承DialogFragment，方便使用的自定义dialog
## Feature
#### 轻量级封装
    与自定义dialog extends DialogFragment 所需实现基本相同，并简化代码，预处理窗口
#### 窗口大小控制 
    添加 setSize(w,h)方法, w/h 可以是百分比浮点数，或者指定dp 确定dialog的大小。(-1 = match_parent ,-2 = wrap_content)
#### 动画及拓展(进入/退出动画，展示动画)
    拓展动画实现方式，可以自定义动画实现。接口方式只提供基本的cancel、confirm，应优先考虑在子类中拓展自定义接口和其他实现

## Usage
    Step 1.
    Step 2.
    Step 3.
## LICENSE
    See license (MIT)