// 柱状图模块1
(function() {
  $.ajax({
    "url": "/WeiBoAgeDataVO",
    "type": "POST",
    "success": function(result){
      // 1实例化对象
      var myChart = echarts.init(document.querySelector(".bar .chart"));
      // 2. 指定配置项和数据
      var option = {
        color: ["#2f89cf"],
        tooltip: {
          trigger: "axis",
          axisPointer: {
            // 坐标轴指示器，坐标轴触发有效
            type: "shadow" // 默认为直线，可选为：'line' | 'shadow'
          }
        },
        // 修改图表的大小
        grid: {
          left: "0%",
          top: "10px",
          right: "0%",
          bottom: "4%",
          containLabel: true
        },
        xAxis: [{
          type: "category",
          data: result.peroids,
          axisTick: {
            alignWithLabel: true
          },
          // 修改刻度标签 相关样式
          axisLabel: {
            color: "rgba(255,255,255,.6) ",
            fontSize: "12"
          },
          // 不显示x坐标轴的样式
          axisLine: {
            show: false
          }
        }],
        yAxis: [{
          type: "value",
          // 修改刻度标签 相关样式
          axisLabel: {
            color: "rgba(255,255,255,.6) ",
            fontSize: 12
          },
          // y轴的线条改为了 2像素
          axisLine: {
            lineStyle: {
              color: "rgba(255,255,255,.1)",
              width: 2
            }
          },
          // y轴分割线的颜色
          splitLine: {
            lineStyle: {
              color: "rgba(255,255,255,.1)"
            }
          }
        }],
        series: [{
          name: "人数",
          type: "bar",
          barWidth: "35%",
          data: result.values,
          itemStyle: {
            // 修改柱子圆角
            barBorderRadius: 5
          }
        }]
      };
      // 3. 把配置项给实例对象
      myChart.setOption(option);
      // 4. 让图表跟随屏幕自动的去适应
      window.addEventListener("resize", function() {
        myChart.resize();
      });
    }
  })
})();
// 柱状图2
(function() {
  $.ajax({
    "url": "/WeiBoLangScales",
    "type": "POST",
    "success": function(result){
      var myChart = echarts.init(document.querySelector(".pie2 .chart"));
      var myColor = ["#1089E7", "#F57474", "#56D0E3", "#F8B448", "#8B78F6"];
      // 1. 实例化对象
      var myChart = echarts.init(document.querySelector(".bar2 .chart"));
      // 2. 指定配置和数据

      var option = {
        grid: {
          top: "10%",
          left: "22%",
          bottom: "10%"
          // containLabel: true
        },
        // 不显示x轴的相关信息
        xAxis: {
          show: false
        },
        yAxis: [{
          type: "category",
          inverse: true,
          data: result.names,
          // 不显示y轴的线
          axisLine: {
            show: false
          },
          // 不显示刻度
          axisTick: {
            show: false
          },
          // 把刻度标签里面的文字颜色设置为白色
          axisLabel: {
            color: "#fff"
          }
        },
          {
            data: result.values,
            inverse: true,
            // 不显示y轴的线
            axisLine: {
              show: false
            },
            // 不显示刻度
            axisTick: {
              show: false
            },
            // 把刻度标签里面的文字颜色设置为白色
            axisLabel: {
              color: "#fff"
            }
          }
        ],
        series: [{
          name: "条",
          type: "bar",
          data: result.scales,
          yAxisIndex: 0,
          // 修改第一组柱子的圆角
          itemStyle: {
            barBorderRadius: 20,
            // 此时的color 可以修改柱子的颜色
            color: function (params) {
              // params 传进来的是柱子对象
              // console.log(params);
              // dataIndex 是当前柱子的索引号
              return myColor[params.dataIndex];
            }
          },
          // 柱子之间的距离
          barCategoryGap: 50,
          //柱子的宽度
          barWidth: 10,
          // 显示柱子内的文字
          label: {
            show: true,
            position: "insideLeft",
            //position: "inside",
            // {c} 会自动的解析为 数据  data里面的数据
            formatter: "{c}%"
          }
        },
          {
            name: "框",
            type: "bar",
            barCategoryGap: 50,
            barWidth: 15,
            yAxisIndex: 1,
            data: [100, 100, 100, 100],
            itemStyle: {
              color: "none",
              borderColor: "#00c1de",
              borderWidth: 3,
              barBorderRadius: 15
            }
          }
        ]
      };

      // 3. 把配置给实例对象
      myChart.setOption(option);
      // 4. 让图表跟随屏幕自动的去适应
      window.addEventListener("resize", function () {
        myChart.resize();
      });}
  });
})();


// 折线图1模块制作
(function() {
  $.ajax({
    "url": "/getHotTopicDataVO",
    "type": "POST",
    "data": {"event": "湖人总冠军"},
    "success":function (result) {
      var yearData = result.hotvalue
      // 1. 实例化对象
      var myChart = echarts.init(document.querySelector(".line .chart"));
      // 2.指定配置
      var option = {
        // 通过这个color修改两条线的颜色
        color: ["#2292DD", "#70CC33"],
        tooltip: {
          trigger: "axis"
        },
        legend: {
          // 如果series 对象有name 值，则 legend可以不用写data
          // 修改图例组件 文字颜色
          textStyle: {
            color: "#4c9bfd"
          },
          // 这个10% 必须加引号
          right: "10%"
        },
        grid: {
          top: "20%",
          left: "3%",
          right: "4%",
          bottom: "3%",
          show: true, // 显示边框
          borderColor: "#012f4a", // 边框颜色
          containLabel: true // 包含刻度文字在内
        },

        xAxis: {
          type: "category",
          boundaryGap: false,
          data: result.hotdate,
          axisTick: {
            show: false // 去除刻度线
          },
          axisLabel: {
            color: "#4c9bfd" // 文本颜色
          },
          axisLine: {
            show: false // 去除轴线
          }
        },
        yAxis: {
          type: "value",
          axisTick: {
            show: false // 去除刻度线
          },
          axisLabel: {
            color: "#4c9bfd" // 文本颜色
          },
          axisLine: {
            show: false // 去除轴线
          },
          splitLine: {
            lineStyle: {
              color: "#012f4a" // 分割线颜色
            }
          }
        },
        series: {
          name: "热度",
          type: "line",
          // true 可以让我们的折线显示带有弧度
          smooth: true,
          data: yearData,
          markPoint: {
            data: [
              {type: 'max', name: '最大值'},
              {type: 'min', name: '最小值'}
            ]
          },
          markLine: {
            data: [
              {type: 'average', name: '平均值'}
            ]
          }
        }

      };

      // 3. 把配置给实例对象
      myChart.setOption(option);
      // 4. 让图表跟随屏幕自动的去适应
      window.addEventListener("resize", function() {
        myChart.resize();
      });

      // 5.点击切换效果
      $(".line h2").on("click", "a", function() {
        // alert(1);
        // console.log($(this).index());
        // 点击 a 之后 根据当前a的索引号 找到对应的 yearData的相关对象
        // console.log(yearData[$(this).index()]);
        var obj = yearData[$(this).index()];
        option.series[0].data = obj.data[0];
        option.series[1].data = obj.data[1];
        // 需要重新渲染
        myChart.setOption(option);
      });

    }
  });

})();
// 折线图2 模块制作
(function() {
  $.ajax({
    url: '/getHotTopicDataVO',
    type: 'POST',
    data: {"event": "青岛疫情"},
    success: function(result) {
      var myChart = echarts.init(document.querySelector('.line2 .chart'));
      var option = {
        tooltip: {
          trigger: 'axis',
        },
        // legend: {
        //     top: '0%',
        //     data: ['邮件营销', '联盟广告', '视频广告', '直接访问', '搜索引擎'],
        //     textStyle: {
        //         color: 'rgba(255,255,255,.5)',
        //         fontSize: '12',
        //     },
        // },

        grid: {
          left: '10',
          top: '30',
          right: '10',
          bottom: '10',
          containLabel: true,
        },
        xAxis: [{
          type: 'category',
          boundaryGap: false,
          // x轴更换数据
          data: result.hotdate,
          // 文本颜色为rgba(255,255,255,.6)  文字大小为 12
          axisLabel: {
            textStyle: {
              color: 'rgba(255,255,255,.6)',
              fontSize: 12,
            },
          },
          // x轴线的颜色为   rgba(255,255,255,.2)
          axisLine: {
            lineStyle: {
              color: 'rgba(255,255,255,.2)',
            },
          },
        }, ],
        yAxis: [{
          type: 'value',
          axisTick: { show: false },
          axisLine: {
            lineStyle: {
              color: 'rgba(255,255,255,.1)',
            },
          },
          axisLabel: {
            textStyle: {
              color: 'rgba(255,255,255,.6)',
              fontSize: 12,
            },
          },
          // 修改分割线的颜色
          splitLine: {
            lineStyle: {
              color: 'rgba(255,255,255,.1)',
            },
          },
        }, ],
        series: [{
          name: '热度',
          type: 'line',
          smooth: true,
          // 单独修改当前线条的样式
          lineStyle: {
            color: '#0184d5',
            width: '2',
          },
          // 填充颜色设置
          areaStyle: {
            color: new echarts.graphic.LinearGradient(
                0,
                0,
                0,
                1, [{
                  offset: 0,
                  color: 'rgba(1, 132, 213, 0.4)', // 渐变色的起始颜色
                },
                  {
                    offset: 0.8,
                    color: 'rgba(1, 132, 213, 0.1)', // 渐变线的结束颜色
                  },
                ],
                false
            ),
            shadowColor: 'rgba(0, 0, 0, 0.1)',
          },
          // 设置拐点
          symbol: 'circle',
          // 拐点大小
          symbolSize: 8,
          // 开始不显示拐点， 鼠标经过显示
          showSymbol: false,
          // 设置拐点颜色以及边框
          itemStyle: {
            color: '#0184d5',
            borderColor: 'rgba(221, 220, 107, .1)',
            borderWidth: 12,
          },
          data: result.hotvalue,
          markPoint: {
            data: [
              {type: 'max', name: '最大值'},
              {type: 'min', name: '最小值'}
            ]
          },
          markLine: {
            data: [
              {type: 'average', name: '平均值'}
            ]
          }
        }
        ],
      };
      myChart.setOption(option);
      // 4. 让图表跟随屏幕自动的去适应
      window.addEventListener('resize', function() {
        myChart.resize();
      });
    },
  });
})();
// 饼形图1
(function() {
  $.ajax({
    "url": "/WeiBoZoneVO",
    "type": "POST",
    "success": function(result) {
      // 1. 实例化对象
      var myChart = echarts.init(document.querySelector(".pie .chart"));
      // 2.指定配置
      var option = {
        color: ["#FF0066", "#FFCC33", "006600", "#66FFFF", "#00FF99","#0000FF","#9900FF","#CC00FF","#FFFFFF"],
        tooltip: {
          trigger: "item",
          formatter: "{a} <br/>{b}: {c} ({d}%)"
        },

        legend: {
          bottom: "0%",
          // 修改小图标的大小
          itemWidth: 10,
          itemHeight: 10,
          // 修改图例组件的文字为 12px
          textStyle: {
            color: "rgba(255,255,255,.5)",
            fontSize: "12"
          }
        },
        series: [{
          name: "年龄分布",
          type: "pie",
          // 这个radius可以修改饼形图的大小
          // radius 第一个值是内圆的半径 第二个值是外圆的半径
          radius: ["40%", "60%"],
          center: ["50%", "45%"],
          avoidLabelOverlap: false,
          // 图形上的文字
          label: {
            show: false,
            position: "center"
          },
          // 链接文字和图形的线是否显示
          labelLine: {
            show: false
          },
          data: result
        }]
      };

      // 3. 把配置给实例对象
      myChart.setOption(option);
      // 4. 让图表跟随屏幕自动的去适应
      window.addEventListener("resize", function() {
        myChart.resize();
      });

    }

  });

})();

// 饼形图2 性别分布图
(function() {
  $.ajax({
    "url": "/weiBoGenderDataVO",
    "type": "POST",
    "success": function(result) {
      var myChart = echarts.init(document.querySelector(".pie2 .chart"));
      var option = {
        color: [
          "#006cff",
          "#60cda0"
          // "#ed8884",
          // "#ff9f7f",
          // "#0096ff",
          // "#9fe6b8",
          // "#32c5e9",
          // "#1d9dff"
        ],
        tooltip: {
          trigger: "item",
          formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
          bottom: "0%",
          itemWidth: 10,
          itemHeight: 10,
          textStyle: {
            color: "rgba(255,255,255,.5)",
            fontSize: "12"
          }
        },
        series: [{
          name: "性别比例",
          type: "pie",
          radius: ["10%", "70%"],
          center: ["50%", "50%"],
          roseType: "radius",
          // 图形的文字标签
          label: {
            fontSize: 10
          },
          // 链接图形和文字的线条
          labelLine: {
            // length 链接图形的线条
            length: 6,
            // length2 链接文字的线条
            length2: 8
          },
          data: result.data
        }]
      };
      myChart.setOption(option);
      // 监听浏览器缩放，图表对象调用缩放resize函数
      window.addEventListener("resize", function() {
        myChart.resize();
      });
    }

  });

})();
// // 秋雁南飞：
// 此版本通过设置geoindex && seriesIndex: [1] 属性来实现geo和map共存，来达到hover散点和区域显示tooltip的效果
// 默认情况下，map series 会自己生成内部专用的 geo 组件。但是也可以用这个 geoIndex 指定一个 geo 组件。这样的话，map 和 其他 series（例如散点图）就可以共享一个 geo 组件了。并且，geo 组件的颜色也可以被这个 map series 控制，从而用 visualMap 来更改。
// 当设定了 geoIndex 后，series-map.map 属性，以及 series-map.itemStyle 等样式配置不再起作用，而是采用 geo 中的相应属性。
// http://echarts.baidu.com/option.html#series-map.geoIndex
// 并且加了pin气泡图标以示数值大小
(function() {

  $.ajax({
    "url": "/provinceDataVO",
    "type": "POST",
    "success": function(result) {
      // var data = Array.from(res);
      var myChart = echarts.init(document.querySelector(".map .chart"));


      var name_title = "微博用户(部分)地区分布图"
      var subname = '数据爬取自微博'
      var nameColor = " rgb(55, 75, 113)"
      var name_fontFamily = '等线'
      var subname_fontSize = 15
      var name_fontSize = 18
      var mapName = 'china'
      var data = result.data;

      var geoCoordMap = {};

      /*获取地图数据*/
      myChart.showLoading();
      var mapFeatures = echarts.getMap(mapName).geoJson.features;
      myChart.hideLoading();
      mapFeatures.forEach(function(v) {
        // 地区名称
        var name = v.properties.name;
        // 地区经纬度
        geoCoordMap[name] = v.properties.cp;

      });

      console.log(data)
      var max = 500,
          min = 10; // todo
      var maxSize4Pin = 50,
          minSize4Pin = 20;

      var convertData = function(data) {
        var res = [];
        for (var i = 0; i < data.length; i++) {
          var geoCoord = geoCoordMap[data[i].name];
          if (geoCoord) {
            res.push({
              name: data[i].name,
              value: geoCoord.concat(data[i].value),
            });
          }
        }
        console.log(res)
        return res;
      };
      option = {
        title: {
          text: name_title,
          subtext: subname,
          x: 'center',
          textStyle: {
            color: nameColor,
            fontFamily: name_fontFamily,
            fontSize: name_fontSize
          },
          subtextStyle: {
            fontSize: subname_fontSize,
            fontFamily: name_fontFamily
          }
        },
        tooltip: {
          trigger: 'item',
          formatter: function(params) {
            console.log(params.data)
            if (params.data.value) {
              var toolTiphtml = params.data.name + ':<br>' + params.data.value
              return toolTiphtml;
            }
            return;
          }
        },
        visualMap: {
          show: true,
          min: 0,
          max: 50,
          left: 'left',
          top: 'bottom',
          text: ['高', '低'], // 文本，默认为数值文本
          calculable: true,
          seriesIndex: [1],
          inRange: {
            // color: ['#3B5077', '#031525'] // 蓝黑
            // color: ['#ffc0cb', '#800080'] // 红紫
            // color: ['#3C3B3F', '#605C3C'] // 黑绿
            // color: ['#0f0c29', '#302b63', '#24243e'] // 黑紫黑
            // color: ['#23074d', '#cc5333'] // 紫红
            // color: ['#00467F', '#A5CC82'] // 蓝绿
            // color: ['#1488CC', '#2B32B2'] // 浅蓝
            color: ['#00467F', '#A5CC82'] // 蓝绿
            // color: ['#00467F', '#A5CC82'] // 蓝绿
            // color: ['#00467F', '#A5CC82'] // 蓝绿
            // color: ['#00467F', '#A5CC82'] // 蓝绿

          }
        },

        geo: {
          show: true,
          map: mapName,
          label: {
            normal: {
              show: false
            },
            emphasis: {
              show: false,
            }
          },
          roam: true,
          itemStyle: {
            normal: {
              areaColor: '#031525',
              borderColor: '#3B5077',
            },
            emphasis: {
              areaColor: '#2B91B7',
            }
          }
        },
        series: [{
          name: '散点',
          type: 'scatter',
          coordinateSystem: 'geo',
          data: convertData(data),
          symbolSize: function(val) {
            return val[2] / 10;
          },
          label: {
            normal: {
              formatter: '{b}',
              position: 'right',
              show: true
            },
            emphasis: {
              show: true
            }
          },
          itemStyle: {
            normal: {
              color: '#05C3F9'
            }
          }
        },
          {
            type: 'map',
            map: mapName,
            geoIndex: 0,
            aspectScale: 0.75, //长宽比
            showLegendSymbol: false, // 存在legend时显示
            label: {
              normal: {
                show: true
              },
              emphasis: {
                show: false,
                textStyle: {
                  color: '#fff'
                }
              }
            },
            roam: true,
            itemStyle: {
              normal: {
                areaColor: '#031525',
                borderColor: '#3B5077',
              },
              emphasis: {
                areaColor: '#2B91B7'
              }
            },
            animation: false,
            data: data
          },
          {
            name: '点',
            type: 'scatter',
            coordinateSystem: 'geo',
            symbol: 'pin', //气泡

            symbolSize: function(val) {
              var a = (maxSize4Pin - minSize4Pin) / (max - min);
              var b = minSize4Pin - a * min;
              b = maxSize4Pin - a * max;
              return a * val[2] + b;
            },
            label: {
              normal: {
                formatter: '{@[2]}',
                show: true,
                textStyle: {
                  color: '#fff',
                  fontSize: 9,
                }
              }
            },
            itemStyle: {
              normal: {
                color: '#F62157', //标志颜色
              }
            },
            zlevel: 6,
            data: convertData(data),
          },
          {
            name: 'Top 5',
            type: 'effectScatter',
            coordinateSystem: 'geo',
            data: convertData(data.sort(function(a, b) {
              return b.value - a.value;
            }).slice(0, 5)),
            symbolSize: function(val) {
              return val[2] / 10;
            },
            showEffectOn: 'render',
            rippleEffect: {
              brushType: 'stroke'
            },
            hoverAnimation: true,
            label: {
              normal: {
                formatter: '{b}',
                position: 'right',
                show: true
              }
            },
            itemStyle: {
              normal: {
                color: 'yellow',
                shadowBlur: 10,
                shadowColor: 'yellow'
              }
            },
            zlevel: 1
          },

        ]
      };

      myChart.setOption(option);
      // 监听浏览器缩放，图表对象调用缩放resize函数
      window.addEventListener("resize", function() {
        myChart.resize();
      });
    }
  });
})();