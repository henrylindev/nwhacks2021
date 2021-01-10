 
const data2 = [
    { name: 'John', score: 80 },
    { name: 'Henry', score: 76 },
    { name: 'Scott', score: 90 },
    { name: 'Gurjot', score: 90 }
  ];
  
  const width2 = 900;
  const height2 = 450;
  const margin2 = { top: 50, bottom: 50, left: 50, right: 50 };
  
  const svg2 = d3.select('#d3-container2')
    .append('svg')
    .attr('width', width2 - margin2.left - margin.right)
    .attr('height', height2 - margin2.top - margin.bottom)
    .attr("viewBox", [0, 0, width2, height]);
  
  const x2 = d3.scaleBand()
    .domain(d3.range(data.length))
    .range([margin2.left, width2 - margin2.right])
    .padding(0.1)
  
  const y2 = d3.scaleLinear()
    .domain([0, 100])
    .range([height2 - margin2.bottom, margin2.top])
  
  svg2
    .append("g")
    .attr("fill", 'royalblue')
    .selectAll("rect")
    .data(data2.sort((a, b) => d3.descending(a.score, b.score)))
    .join("rect")
      .attr("x", (d, i) => x(i))
      .attr("y", d => y(d.score))
      .attr('title', (d) => d.score)
      .attr("class", "rect")
      .attr("height", d => y(0) - y(d.score))
      .attr("width", x.bandwidth());
  
  function yAxis(g) {
    g.attr("transform", `translate(${margin.left}, 0)`)
      .call(d3.axisLeft(y2).ticks(null, data2.format))
      .attr("font-size", '20px')
  }
  
  function xAxis(g) {
    g.attr("transform", `translate(0,${height2 - margin.bottom})`)
      .call(d3.axisBottom(x2).tickFormat(i => data2[i].name))
      .attr("font-size", '20px')
  }

  
  
  svg2.append("g").call(xAxis);
  svg2.append("g").call(yAxis);
  svg2.node();