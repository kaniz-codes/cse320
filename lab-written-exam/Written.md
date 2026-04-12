# Lab Written Exam

## Topics
- [Network Cabling](#network-cabling)  
- [HTTP / DNS / FTP Server Configuration](#http--dns--ftp-server-configuration)  
- [VLAN Configuration](#vlan-configuration)  
- [Static Routing Configuration](#static-routing-configuration)  
- [RIP Routing Configuration](#rip-routing-configuration)  
- [Wireless Routing Configuration (One Hop)](#wireless-routing-configuration-one-hop)  
---

## Network Cabling

### a) Difference between Straight-through and Crossover Cable

| Feature  | Straight-through Cable              | Crossover Cable                          |
|----------|------------------------------------|------------------------------------------|
| Wiring   | Same color order on both ends      | Different color order on ends            |
| Purpose  | Connect different devices          | Connect similar devices                  |
| Example  | PC → Switch                        | Switch → Switch, PC → PC                 |
| Signal   | No swapping                        | Transmit & Receive are swapped           |



### b) T568A and T568B Standards

These are wiring standards used for arranging wires inside Ethernet cables.  
They define the color code sequence of 8 wires.

| **T568A Color Order** | **T568B Color Order** |
|----------------------|----------------------|
| White-Green          | White-Orange         |
| Green                | Orange               |
| White-Orange         | White-Green          |
| Blue                 | Blue                 |
| White-Blue           | White-Blue           |
| Orange               | Green                |
| White-Brown          | White-Brown          |
| Brown                | Brown                |

**Difference:** Only **orange and green pairs are swapped**.



### c) Cable Usage

- PC → Switch → Straight-through cable  
- Switch → Switch → Crossover cable  



### d) Purpose of Network Cabling

The purpose of **network cabling** is to connect different network devices and enable communication between them.

It allows devices such as computers, switches, routers, and servers to **transmit data and share resources efficiently**.

#### Main purposes:

- **Data transmission** → Sends and receives data  
- **Device connectivity** → Connects network devices  
- **Resource sharing** → Files, printers, internet  
- **Reliable communication** → Stable and secure connection  
- **Network performance** → Fast and efficient transfer  

#### Conclusion:
Network cabling forms the **physical backbone of a network**.



## HTTP / DNS / FTP Server Configuration

### a) What is HTTP Server?

An **HTTP (HyperText Transfer Protocol) server** stores and delivers web pages to clients (browsers).

- Uses **HTTP protocol**  
- Default port: **80**  
- Sends requested web pages to browsers  

**Examples:** Apache, Nginx  

Used for **hosting websites and web applications**.



### b) What is DNS and how it works?

**DNS (Domain Name System)** converts domain names into IP addresses.

**Example:**  
`www.google.com → 142.x.x.x`

#### Working Process:

1. User enters domain name  
2. DNS receives request  
3. Searches for IP address  
4. Returns IP to browser  
5. Browser connects to server  

DNS eliminates the need to remember IP addresses.



### c) What is FTP and its uses?

**FTP (File Transfer Protocol)** transfers files between computers.

- Default port: **21**

#### Uses:

- Upload files  
- Download files  
- Share data  
- Manage website files  

#### Commands:

- `put` → upload  
- `get` → download  



## VLAN Configuration

### a) What is VLAN and why is it used?

A **VLAN (Virtual Local Area Network)** logically groups devices regardless of physical location.  
It divides a network into multiple **broadcast domains**.

#### Uses:

- Improves security  
- Reduces broadcast traffic  
- Better network management  
- Enhances performance  



### b) VLAN 10 Configuration

```bash
enable
configure terminal
vlan 10
name VLAN10
exit
interface fastethernet 0/1
switchport mode access
switchport access vlan 10
exit
```

### c) What is the difference between access port and trunk port?

| Feature        | Access Port                 | Trunk Port                     |
|----------------|----------------------------|--------------------------------|
| VLAN support   | Single VLAN                | Multiple VLANs                 |
| Traffic type   | Untagged                   | Tagged                         |
| Usage          | Connect end devices (PCs)  | Connect switches/routers       |
| Configuration  | Simple                     | More complex                   |

### Conclusion

Access ports are used for end devices, while trunk ports are used to carry traffic between network devices across multiple VLANs.

## Static Routing Configuration

### 1. What is static routing, why we use it, and how it works

**Answer:**

**Static routing** is a method of routing where routes are **manually configured** by the network administrator in the routing table.

#### Why it is used:

- Suitable for small networks  
- Provides better security (no automatic updates)  
- Gives full control over routing  
- Uses less bandwidth (no routing updates)  

#### How it works:

- The administrator enters a route manually using commands  
- The router stores this route in its routing table  
- When a packet arrives, the router checks the destination network  
- It forwards the packet to the specified **next-hop address**  

## RIP Routing Configuration

### 2. What is RIP and how it works

**Answer:**

**RIP (Routing Information Protocol)** is a dynamic routing protocol that automatically updates routing tables.

- It uses **hop count** as a metric  
- Maximum hop count is **15**  

#### How it works:

- Routers share their routing tables with neighbors every 30 seconds  
- Each router calculates the best path based on **minimum hop count**  
- If a route changes, it is automatically updated  
- If hop count exceeds 15, the network cannot be reached    

---

### 3. Difference between Static Routing and Dynamic Routing

| Feature           | Static Routing                     | Dynamic Routing                     |
|------------------|-----------------------------------|-------------------------------------|
| Configuration    | Manual                            | Automatic                           |
| Updates          | No updates                        | Updates automatically               |
| Complexity       | Simple                            | Complex                             |
| Scalability      | Not suitable for large networks   | Suitable for large networks         |
| Bandwidth usage  | Low                               | Higher (due to updates)             |

### 4. When would you use static routing instead of RIP?

**Answer:**

Static routing is used instead of RIP in the following cases:

- In **small networks** with few routers  
- When **network paths do not change frequently**  
- When **security is important** (no route advertisements)  
- When **low bandwidth usage** is required  
- When **simple configuration** is preferred  

## Wireless Routing Configuration

### 1. What is wireless routing and how it works

**Answer:**

Wireless routing means connecting devices to a network using **Wi-Fi instead of cables**.

A **wireless router** is used to send and receive data.

#### How it works:

- The router is connected to the internet  
- It sends signals through the air (Wi-Fi)  
- Devices connect using **SSID (Wi-Fi name) and password**  
- Data is sent from device → router → internet  

---

### 2. Advantages of wireless routing

**Answer:**

- No need for cables  
- Easy to install  
- Users can move freely  
- Can connect many devices  
- Saves time and cost  

### Why is `192.168.1.0` used in static routing (why 0 at the end)?

**Answer:**

`192.168.1.0` is a **network address**, not a host address.

- In a subnet like **192.168.1.0/24**, the last part (`.0`) represents the **network ID**  
- It identifies the whole network, not a specific device  
- Routers use the **network address** to route traffic to that entire network  

**Example:**
- Network: `192.168.1.0`  
- Usable IPs: `192.168.1.1 – 192.168.1.254`  
- Broadcast: `192.168.1.255`  

So, we use `.0` because it represents the **entire network**.

---

### Which is better: Static Routing or RIP? Why?

**Answer:**

It depends on the network size and requirement.

#### Static Routing is better when:
- The network is **small**  
- Routes do not change often  
- **Security** is important  
- You want **full control**  
- You want to save **bandwidth**

#### RIP is better when:
- The network is **large**  
- Routes change frequently  
- You want **automatic updates**  
- Easy to manage without manual configuration  

#### Conclusion:
- **Static routing** is better for **small and secure networks**  
- **RIP** is better for **large and dynamic networks**