package com.example.data.local

object SeedStd11And12 {

  private const val TRADE_11_12_GU = "ફિલ્ડ ટેકનિશિયન — કમ્પ્યુટિંગ પેરિફેરલ્સ (PSSCIVE/NCERT)"
  private const val TRADE_11_12_HI = "फील्ड तकनीशियन — कंप्यूटिंग पेरिफेरल्स (PSSCIVE/NCERT)"
  private const val TRADE_11_12_EN = "Field Technician Computing Peripherals (PSSCIVE/NCERT)"

  val lessons: List<LessonEntity> =
    listOf(
      // ==================== GRADE XI ====================
      LessonEntity(
        lessonId = "lesson_11_1",
        classStd = 11,
        chapterCode = "Std 11 • Module 1 (Sessions 1–4)",
        tradeNameGu = TRADE_11_12_GU,
        tradeNameHi = TRADE_11_12_HI,
        tradeNameEn = TRADE_11_12_EN,
        unitTitleGu = "કમ્પ્યુટર અને તેના પેરિફેરલ્સના મૂળભૂત સિદ્ધાંતો",
        unitTitleHi = "कंप्यूटर और इसके पेरिफेरल्स के मूल सिद्धांत",
        unitTitleEn = "Fundamental of Computer and Its Peripherals",
        titleGu = "મોડ્યુલ 1: કમ્પ્યુટર સિસ્ટમ, I/O ઉપકરણો અને સ્ટોરેજ પેરિફેરલ્સ",
        titleHi = "मॉड्यूल 1: कंप्यूटर सिस्टम, इनपुट/आउटपुट और स्टोरेज पेरिफेरल्स",
        titleEn = "Module 1: Computer Architecture, I/O & Storage Peripherals",
        summaryGu =
          "ફિલ્ડ ટેકનિશિયનની ભૂમિકા, IPO ચક્ર (CPU/ALU/CU), ઇનપુટ-આઉટપુટ પોર્ટ્સ અને HDD/SSD/પ્રિન્ટર સ્ટોરેજ.",
        summaryHi =
          "फील्ड तकनीशियन की भूमिका, IPO चक्र (CPU/ALU/CU), इनपुट-आउटपुट पोर्ट और HDD/SSD/प्रिंटर स्टोरेज।",
        summaryEn =
          "Technician roles, computer functional block (IPO/CPU/RAM), I/O devices, and HDD/SSD/peripheral interfaces.",
        learningOutcomesGu =
          "• કમ્પ્યુટિંગ અને પેરિફેરલ્સ ટેકનિશિયનની ફરજો સમજવી.\n• Input → Process (CPU: ALU + CU) → Output → Storage ચક્ર સમજાવવું.\n• ઇનપુટ (કીબોર્ડ, માઉસ, સ્કેનર) અને આઉટપુટ (મોનિટર, પ્રિન્ટર) ઓળખવા.\n• RAM, ROM, HDD, NVMe SSD અને USB/HDMI/RJ45 પોર્ટ્સ ઇન્સ્ટોલ કરવા.",
        learningOutcomesHi =
          "• कंप्यूटिंग पेरिफेरल्स फील्ड तकनीशियन के कार्य और दायित्व समझना।\n• कंप्यूटर सिस्टम के मुख्य भाग (ALU, CU, मेमोरी, बस) की कार्यप्रणाली बताना।\n• इनपुट, आउटपुट और स्टोरेज डिवाइस (SSD/HDD) की स्थापना समझना।",
        learningOutcomesEn =
          "• Understand key roles and responsibilities of a Computing Peripherals Field Technician.\n• Explain core computer functionality (Input, CPU ALU/CU, Memory, Output).\n• Identify I/O devices, storage types (HDD vs SSD), and motherboard ports.",
        bodyGu =
          "📌 સેશન 1 — ટેકનિશિયનની ભૂમિકા: PC અને પેરિફેરલ્સ ઇન્સ્ટોલ કરવા, કસ્ટમરની સમસ્યા સાંભળવી, ESD સુરક્ષા જાળવવી.\n\n📌 સેશન 2 — કમ્પ્યુટરની કાર્યપદ્ધતિ: ઇનપુટ ડેટા પ્રાથમિક મેમરી (RAM) માં જાય છે; CPU ના બે ભાગ — ALU (ગણતરી/તર્ક) અને CU (નિયંત્રણ) — પ્રોસેસ કરી આઉટપુટ આપે છે.\n\n📌 સેશન 3 — ઇનપુટ અને આઉટપુટ: કીબોર્ડ, માઉસ, વેબકેમ, બારકોડ સ્કેનર (Input) તથા LCD/LED મોનિટર, ઇંકજેટ/લેસર પ્રિન્ટર (Output).\n\n📌 સેશન 4 — સ્ટોરેજ અને પેરિફેરલ્સ: પ્રાથમિક (RAM અસ્થાયી, ROM/BIOS કાયમી) અને સેકન્ડરી (SATA HDD, M.2 NVMe SSD, USB પેનડ્રાઇવ).",
        bodyHi =
          "📌 सत्र 1 — तकनीशियन की भूमिका: हार्डवेयर इंस्टॉलेशन, पेरिफेरल कनेक्शन और ग्राहक समस्या निवारण।\n\n📌 सत्र 2 — कंप्यूटर की कार्यप्रणाली: इनपुट → प्रोसेसिंग (CPU के ALU व Control Unit द्वारा) → आउटपुट। RAM अस्थायी और ROM स्थायी मेमोरी है।\n\n📌 सत्र 3 — इनपुट/आउटपुट उपकरण: कीबोर्ड, माउस, स्कैनर, मॉनिटर, लेज़र व इंकजेट प्रिंटर।\n\n📌 सत्र 4 — स्टोरेज और पेरिफेरल्स: SATA HDD (चुंबकीय डिस्क), M.2 NVMe SSD (तेज़ फ्लैश मेमोरी), USB, HDMI और ईथरनेट RJ45।",
        bodyEn =
          "📌 Session 1 — Technician Role: Installing desktops/peripherals, ESD handling, diagnosing faults, and logging service calls.\n\n📌 Session 2 — Computer System Functionality: Input → Process (CPU = ALU + Control Unit + Registers) → Output.\n\n📌 Session 3 — Input & Output Devices: Keyboard, optical mouse, scanner, barcode reader; LED monitor, inkjet & laser printers.\n\n📌 Session 4 — Storage & Peripherals: Volatile RAM vs non-volatile ROM/CMOS; SATA HDD vs high-speed M.2 NVMe SSD.",
        equationsGu =
          "• મેમરી એકમો: 1 Byte = 8 Bits  |  1 KB = 1024 B  |  1 GB = 1024 MB  |  1 TB = 1024 GB\n• CPU ક્લોક સ્પીડ: 1 GHz = 10⁹ સાયકલ પ્રતિ સેકન્ડ\n• ડેટા ટ્રાન્સફર: USB 3.0 = 5 Gbps  |  SATA III = 6 Gbps",
        equationsHi =
          "• मेमोरी इकाइयाँ: 1 Byte = 8 Bits  |  1 KB = 1024 B  |  1 GB = 1024 MB  |  1 TB = 1024 GB\n• CPU क्लॉक स्पीड: 1 GHz = 10⁹ चक्र/सेकंड\n• इंटरफेस स्पीड: USB 3.0 = 5 Gbps  |  SATA III = 6 Gbps",
        equationsEn =
          "• Memory Units: 1 Byte = 8 Bits  |  1 KB = 1024 B  |  1 MB = 1024 KB  |  1 GB = 1024 MB\n• CPU Clock: 1 GHz = 10⁹ cycles/sec\n• Interface Bandwidth: USB 3.0 = 5 Gbps  |  SATA III = 6 Gbps",
        impQuestionsGu =
          "Q: CPU ના મુખ્ય બે ભાગ (ALU અને CU) નું કાર્ય શું છે?\nA: ALU (Arithmetic Logic Unit) ગાણિતિક (+,-,*,/) અને તાર્કિક સરખામણી કરે છે; CU (Control Unit) મેમરી અને I/O વચ્ચે ડેટા પ્રવાહનું સંચાલન કરે છે.\n---\nQ: HDD અને SSD વચ્ચે મુખ્ય તફાવત શું છે?\nA: HDD માં ફરતી ચુંબકીય ડિસ્ક હોય છે (ધીમી, ઓછી કિંમત), જ્યારે SSD માં કોઈ ફરતા ભાગ નથી (ફ્લેશ મેમરી, 5–10× ઝડપી, શોક-પ્રૂફ).\n---\nQ: RAM અને ROM વચ્ચે શું તફાવત છે?\nA: RAM (Volatile) માં પાવર બંધ થતાં ડેટા ભૂંસાય છે; ROM/UEFI (Non-Volatile) માં બૂટ ફર્મવેર કાયમ સચવાય છે.",
        impQuestionsHi =
          "Q: CPU के ALU और CU का क्या कार्य है?\nA: ALU गणितीय व तार्किक गणना करता है, जबकि CU सभी हार्डवेयर और मेमोरी के बीच निर्देशों का नियंत्रण करता है।\n---\nQ: HDD और SSD में कौन तेज़ है और क्यों?\nA: SSD (Solid State Drive) अधिक तेज़ है क्योंकि इसमें यांत्रिक घूमने वाली डिस्क नहीं होती और यह फ्लैश चिप का उपयोग करती है।\n---\nQ: लेज़र प्रिंटर और इंकजेट प्रिंटर में मुख्य अंतर क्या है?\nA: लेज़र प्रिंटर सूखे टोनर पाउडर व फ्यूज़र का उपयोग करता है (तेज़ प्रिंटिंग), जबकि इंकजेट तरल स्याही छिड़कता है।",
        impQuestionsEn =
          "Q: Distinguish between ALU and Control Unit inside a CPU.\nA: ALU executes arithmetic and logic operations; Control Unit fetches, decodes, and directs signals across buses.\n---\nQ: Why is an NVMe M.2 SSD much faster than a SATA HDD?\nA: NVMe SSD uses solid-state NAND flash directly over PCIe lanes with zero mechanical seek delay.\n---\nQ: What is the difference between RAM and Secondary Storage?\nA: RAM is fast volatile working memory; SSD/HDD is non-volatile long-term storage.",
        rememberTipGu = "ક્યારેય M.2 NVMe SSD અને SATA SSD ને ભેળસેળ ન કરો — મધરબોર્ડ સ્લોટ Key (M-Key vs B+M) તપાસો.",
        rememberTipHi = "M.2 स्लॉट में SSD लगाने से पहले M-Key (NVMe) और SATA सपोर्ट की पुष्टि मदरबोर्ड मैनुअल से करें।",
        rememberTipEn = "Remember IPO: Input → Process (CPU + RAM) → Output, with CMOS/ROM storing BIOS/UEFI boot firmware.",
        glossaryGu = "ALU: ગણિત-તર્ક એકમ • BIOS/UEFI: બૂટ ફર્મવેર • NVMe: ઝડપી PCIe SSD ઇન્ટરફેસ",
        glossaryHi = "ALU: अंकगणित-तर्क इकाई • UEFI: बूट फर्मवेयर • NVMe: हाई-स्पीड PCIe SSD मानक",
        glossaryEn = "POST: Power-On Self-Test • UEFI: Unified Extensible Firmware Interface • Volatile Memory",
        circuitDiagramId = "circuit_computer_block",
        linkedPracticalId = "prac_11_1",
        estimatedMinutes = 15,
        downloadSizeKb = 710,
        isDownloadedOffline = true,
        sortOrder = 7,
      ),

      LessonEntity(
        lessonId = "lesson_11_2",
        classStd = 11,
        chapterCode = "Std 11 • Module 2 (Sessions 1–5)",
        tradeNameGu = TRADE_11_12_GU,
        tradeNameHi = TRADE_11_12_HI,
        tradeNameEn = TRADE_11_12_EN,
        unitTitleGu = "ઓપરેટિંગ સિસ્ટમનું ઇન્સ્ટોલેશન અને કન્ફિગરેશન",
        unitTitleHi = "ऑपरेटिंग सिस्टम की स्थापना एवं कॉन्फ़िगरेशन",
        unitTitleEn = "Installation and Configuration of Operating Systems",
        titleGu = "મોડ્યુલ 2: OS કાર્યો, Windows અને Linux ઇન્સ્ટોલેશન અને ડ્રાઇવર સેટઅપ",
        titleHi = "मॉड्यूल 2: OS के कार्य, Windows और Linux इंस्टॉलेशन व पेरिफेरल सेटअप",
        titleEn = "Module 2: OS Functions, Windows & Linux Setup",
        summaryGu = "ઓપરેટિંગ સિસ્ટમના કાર્યો, UEFI/GPT બૂટેબલ USB, Windows ઇન્સ્ટોલ-કન્ફિગર, Linux ઇન્સ્ટોલ અને પેરિફેરલ ડ્રાઇવર્સ.",
        summaryHi = "ऑपरेटिंग सिस्टम के कार्य, बूटेबल USB, Windows और Linux इंस्टॉलेशन तथा पेरिफेरल कॉन्फ़िगरेशन।",
        summaryEn = "OS kernel/file management, Windows installation & configuration, Ubuntu/Linux setup, and peripheral drivers.",
        learningOutcomesGu =
          "• OS ના મુખ્ય કાર્યો (પ્રોસેસ, મેમરી, ફાઇલ અને ડિવાઇસ મેનેજમેન્ટ) સમજવા.\n• બૂટેબલ USB બનાવી Windows OS ઇન્સ્ટોલ અને કન્ફિગર કરવી.\n• Linux OS (ext4/swap પાર્ટીશન) ઇન્સ્ટોલ કરી પ્રિન્ટર/નેટવર્ક પેરિફેરલ્સ જોડવા.",
        learningOutcomesHi =
          "• ऑपरेटिंग सिस्टम के कार्य (मेमोरी, प्रोसेस, फाइल व डिवाइस प्रबंधन) समझना।\n• Windows OS को BIOS/UEFI से इंस्टॉल व कॉन्फ़िगर करना।\n• Linux OS इंस्टॉल कर उसमें प्रिंटर व अन्य पेरिफेरल्स सेट करना।",
        learningOutcomesEn =
          "• Explain core OS functions: process, memory, file system & device driver management.\n• Create bootable USB media and install/configure Windows OS.\n• Install Linux OS (ext4, swap) and configure printers/peripherals in Linux.",
        bodyGu =
          "📌 સેશન 1 — OS ના કાર્યો: હાર્ડવેર અને વપરાશકર્તા વચ્ચેનો સેતુ. પ્રોસેસ શેડ્યુલિંગ, RAM ફાળવણી, NTFS/ext4 ફાઇલ સિસ્ટમ અને ડિવાઇસ ડ્રાઇવર.\n\n📌 સેશન 2 અને 3 — Windows ઇન્સ્ટોલેશન અને કન્ફિગરેશન: BIOS/UEFI બૂટ ઓર્ડરમાં USB પ્રથમ મૂકો → GPT/NTFS પાર્ટીશન બનાવો → ભાષા/યુઝર સેટઅપ → Device Manager માંથી ચિપસેટ/ગ્રાફિક્સ/નેટવર્ક ડ્રાઇવર્સ અને Windows Update પૂર્ણ કરો.\n\n📌 સેશન 4 અને 5 — Linux ઇન્સ્ટોલેશન અને પેરિફેરલ્સ: Live USB થી બૂટ → `/` (root, ext4), `/home` અને `swap` પાર્ટીશન → ઇન્સ્ટોલ પછી `lsusb` / `lspci` થી હાર્ડવેર તપાસવું અને CUPS (`localhost:631`) દ્વારા પ્રિન્ટર કન્ફિગર કરવું.",
        bodyHi =
          "📌 सत्र 1 — OS के कार्य: यूज़र और हार्डवेयर के बीच इंटरफेस; मेमोरी, फाइल सिस्टम (NTFS/ext4) और ड्राइवर नियंत्रण।\n\n📌 सत्र 2 व 3 — Windows इंस्टॉलेशन व कॉन्फ़िगरेशन: UEFI से USB बूट, ड्राइव पार्टीशन, यूज़र अकाउंट, Device Manager द्वारा ड्राइवर इंस्टॉल और डिस्प्ले/नेटवर्क सेटिंग्स।\n\n📌 सत्र 4 व 5 — Linux इंस्टॉलेशन व पेरिफेरल सेटअप: `/` (ext4) व `swap` पार्टीशन बनाकर Linux इंस्टॉल करें; `lsusb`, `sudo apt update` और CUPS से प्रिंटर/स्कैनर जोड़ें।",
        bodyEn =
          "📌 Session 1 — Functions of OS: Process scheduling, RAM allocation, file systems (NTFS/FAT32/ext4), security, and driver control.\n\n📌 Sessions 2 & 3 — Install & Configure Windows: Set USB first in UEFI boot menu, partition GPT/NTFS drive, create user account, install chipset/GPU/NIC drivers via Device Manager, and enable updates.\n\n📌 Sessions 4 & 5 — Install Linux & Peripherals: Boot Live Linux USB, configure `/` (ext4) + `swap` partitions, verify hardware via `lsusb`/`lspci`, and add printers using CUPS.",
        equationsGu =
          "• Swap મેમરી નિયમ (Linux): RAM ≤ 4GB → Swap = 2 × RAM  |  RAM ≥ 8GB → Swap ≈ 4–8 GB\n• બૂટેબલ સ્કીમ: UEFI Mode ↔ GPT Partition  |  Legacy BIOS ↔ MBR Partition\n• ફાઇલ સિસ્ટમ: Windows = NTFS  |  Linux = ext4  |  USB Pen Drive = FAT32 / exFAT",
        equationsHi =
          "• Swap मेमोरी नियम (Linux): RAM ≤ 4GB → Swap = 2 × RAM  |  RAM ≥ 8GB → Swap ≈ 4–8 GB\n• बूट मानक: UEFI Mode ↔ GPT पार्टीशन  |  Legacy BIOS ↔ MBR पार्टीशन\n• फाइल सिस्टम: Windows = NTFS  |  Linux = ext4  |  USB = FAT32 / exFAT",
        equationsEn =
          "• Linux Swap Sizing: RAM ≤ 4GB → Swap = 2×RAM  |  RAM ≥ 8GB → 4–8 GB Swap\n• Boot Pairing Rule: UEFI ↔ GPT (supports >2 TB)  |  Legacy BIOS ↔ MBR\n• File Systems: Windows = NTFS  |  Linux = ext4  |  Cross-OS USB = exFAT / FAT32",
        impQuestionsGu =
          "Q: OS ઇન્સ્ટોલ કરતા પહેલાં ડેટા બેકઅપ અને UEFI/GPT ચેક કેમ જરૂરી છે?\nA: પાર્ટીશન ફોર્મેટ કરવાથી જૂનો ડેટા ભૂંસાઈ જાય છે, અને ખોટું MBR/GPT મેચ બૂટ એરર આપે છે.\n---\nQ: ડિવાઇસ ડ્રાઇવર શું છે?\nA: એક નાનો સોફ્ટવેર પ્રોગ્રામ જે OS ને પ્રિન્ટર, ગ્રાફિક્સ કાર્ડ કે Wi-Fi એડેપ્ટર સાથે વાત કરતા શીખવે છે.\n---\nQ: Linux માં `lsusb` અને `sudo apt update` કમાન્ડ શું કામ કરે છે?\nA: `lsusb` જોડાયેલા USB ઉપકરણો બતાવે છે અને `apt update` સોફ્ટવેર/ડ્રાઇવર પેકેજની યાદી તાજી કરે છે.",
        impQuestionsHi =
          "Q: डिवाइस ड्राइवर (Device Driver) क्या होता है?\nA: यह विशेष सॉफ्टवेयर है जो OS को प्रिंटर, ऑडियो या नेटवर्क कार्ड जैसे हार्डवेयर से संवाद करने में सक्षम बनाता है।\n---\nQ: GPT और MBR में मुख्य अंतर क्या है?\nA: GPT आधुनिक UEFI सिस्टम में चलता है और 2 TB से बड़ी ड्राइव व 128 तक पार्टीशन सपोर्ट करता है, जबकि MBR 2 TB तक सीमित है।\n---\nQ: Linux में पेरिफेरल जोड़ने के बाद जांचने का कमांड क्या है?\nA: `lsusb` (USB डिवाइस के लिए) और `lspci` (मदरबोर्ड PCI डिवाइस के लिए)।",
        impQuestionsEn =
          "Q: Why must UEFI firmware be paired with GPT instead of MBR?\nA: UEFI expects a GPT EFI System Partition (ESP) and supports drives >2 TB and up to 128 primary partitions.\n---\nQ: What is the purpose of a Device Driver after OS installation?\nA: It translates generic OS calls into hardware-specific commands for printers, GPUs, audio, and network adapters.\n---\nQ: Which Linux commands verify connected USB and PCI peripherals?\nA: `lsusb` lists USB devices and `lspci` lists internal PCIe/chipset devices.",
        rememberTipGu = "OS ઇન્સ્ટોલ કરતી વખતે હંમેશા C: ડ્રાઇવ કે લક્ષ્ય પાર્ટીશનનું કદ (GB) જોઈને જ ફોર્મેટ કરો જેથી D: ડેટા સુરક્ષિત રહે!",
        rememberTipHi = "OS इंस्टॉल करते समय आकार (GB) देखकर ही सही पार्टीशन फॉर्मेट करें ताकि ग्राहक का डेटा न मिटे!",
        rememberTipEn = "Always verify partition size/label and back up user files before formatting during OS installation!",
        glossaryGu = "GPT: GUID પાર્ટીશન ટેબલ • Dual Boot: એક PC માં 2 OS • CUPS: Linux પ્રિન્ટ સિસ્ટમ",
        glossaryHi = "GPT: GUID पार्टीशन टेबल • Dual Boot: एक PC में 2 OS • CUPS: Linux प्रिंटिंग सेवा",
        glossaryEn = "UEFI: Modern firmware • Partition: Logical drive section • Device Manager / CUPS",
        circuitDiagramId = null,
        linkedPracticalId = "prac_11_2",
        estimatedMinutes = 16,
        downloadSizeKb = 740,
        isDownloadedOffline = true,
        sortOrder = 8,
      ),

      LessonEntity(
        lessonId = "lesson_11_3",
        classStd = 11,
        chapterCode = "Std 11 • Module 3 (Sessions 1–4)",
        tradeNameGu = TRADE_11_12_GU,
        tradeNameHi = TRADE_11_12_HI,
        tradeNameEn = TRADE_11_12_EN,
        unitTitleGu = "મૂળભૂત ઇલેક્ટ્રોનિક્સ, સાધનો અને કમ્પ્યુટરના ભાગો",
        unitTitleHi = "इलेक्ट्रॉनिक्स के मूल सिद्धांत, उपकरण एवं मापन यंत्र",
        unitTitleEn = "Basic of Electronics, Tools and Equipment",
        titleGu = "મોડ્યુલ 3: PC ઇલેક્ટ્રોનિક્સ, SMPS પાવર રેલ્સ, ફેન્સ અને માપન સાધનો",
        titleHi = "मॉड्यूल 3: PC इलेक्ट्रॉनिक्स, SMPS पावर रेल, कूलिंग पार्ट्स और टूल्स",
        titleEn = "Module 3: PC Electronics, SMPS Rails & Measuring Instruments",
        summaryGu = "ઇલેક્ટ્રોનિક ઘટકો, SMPS ના +12V/+5V/+3.3V રેલ, CPU કૂલર/મિકેનિકલ ભાગો અને ESD/DMM સાધનો.",
        summaryHi = "इलेक्ट्रॉनिक घटक, SMPS के +12V/+5V/+3.3V वोल्टेज, कूलिंग फैन और ESD/DMM टूल्स।",
        summaryEn = "Electronics basics, SMD board components, ATX SMPS electrical/mechanical parts, and ESD/DMM tools.",
        learningOutcomesGu =
          "• મધરબોર્ડ પરના SMD રેઝિસ્ટર, કેપેસિટર, મોસ્ફેટ, ઇન્ડક્ટર અને ક્રિસ્ટલ ઓળખવા.\n• કમ્પ્યુટરમાં SMPS, કૂલિંગ ફેન, હીટ-સિંક અને ઓપ્ટિકલ/HDD મોટરનું કાર્ય સમજવું.\n• એન્ટિ-સ્ટેટિક (ESD) પટ્ટો, ક્રિમ્પિંગ ટૂલ અને મલ્ટિમીટરથી SMPS વોલ્ટેજ માપવા.",
        learningOutcomesHi =
          "• मदरबोर्ड के SMD रेजिस्टर, कैपेसिटर, मॉस्फेट और कॉइल पहचानना।\n• कंप्यूटर में SMPS (+12V/+5V/+3.3V), हीट-सिंक, फैन और मैकेनिकल भागों के कार्य समझना।\n• ESD रिस्ट स्ट्रैप और DMM से ATX पावर सप्लाई रेल मापना।",
        learningOutcomesEn =
          "• Identify electronic circuit components on PC motherboards (SMD resistors, capacitors, inductors, MOSFETs).\n• Explain electrical & mechanical parts inside a PC (SMPS rails, PWM fans, heatsink, latches).\n• Use ESD wrist straps, precision screwdrivers, and DMM to test SMPS rails.",
        bodyGu =
          "📌 સેશન 1 અને 2 — ઇલેક્ટ્રોનિક્સ અને સર્કિટ ઘટકો: મધરબોર્ડમાં સોલિડ-સ્ટેટ કેપેસિટર, VRM ચોક કોઇલ (Inductor), MOSFET સ્વિચ, BIOS ROM ચિપ અને 32.768 kHz RTC ક્રિસ્ટલ હોય છે.\n\n📌 સેશન 3 — કમ્પ્યુટરના ઇલેક્ટ્રિકલ અને મિકેનિકલ ભાગો: SMPS (Switched-Mode Power Supply) મુખ્ય 230V AC ને +12V (CPU/GPU/Fans), +5V (USB/HDD Logic), અને +3.3V (RAM/Chipset) માં ફેરવે છે. મિકેનિકલ ભાગોમાં હીટ-સિંક ફિન્સ, I/O શીલ્ડ અને ડ્રાઇવ બે સામેલ છે.\n\n📌 સેશન 4 — સાધનો અને માપન: ESD એન્ટિ-સ્ટેટિક કાંડા પટ્ટો, મેગ્નેટિક સ્ક્રુડ્રાઇવર, એર બ્લોઅર અને ડિજિટલ મલ્ટિમીટર.",
        bodyHi =
          "📌 सत्र 1 व 2 — इलेक्ट्रॉनिक्स और घटक: मदरबोर्ड पर सॉलिड कैपेसिटर, VRM चोक कॉइल, MOSFET, BIOS चिप और RTC क्रिस्टल लगे होते हैं।\n\n📌 सत्र 3 — इलेक्ट्रिकल व मैकेनिकल भाग: SMPS 230V AC को +12V (CPU/फैन), +5V (USB/लॉजिक) और +3.3V (चिपसेट/RAM) में बदलता है। हीट-सिंक व कैबिनेट फैन कूलिंग देते हैं।\n\n📌 सत्र 4 — उपकरण व मापन यंत्र: ESD रिस्ट स्ट्रैप, प्रिसीजन स्क्रूड्राइवर, ब्लोअर और डिजिटल मल्टीमीटर।",
        bodyEn =
          "📌 Sessions 1 & 2 — Electronics & Components: Motherboards rely on solid-polymer capacitors, VRM choke inductors, MOSFETs, BIOS flash ICs, and RTC crystals.\n\n📌 Session 3 — Electrical & Mechanical PC Parts: ATX SMPS converts 230V AC into +12V (CPU/GPU/Fans), +5V (USB/Drives), +3.3V (Chipset/Logic) and +5VSB standby. Mechanical parts include heatsinks, fans, and drive cages.\n\n📌 Session 4 — Tools & Measuring Instruments: ESD wrist strap, anti-static mat, magnetic driver kit, air blower, and DMM.",
        equationsGu =
          "• ATX SMPS સહનશીલતા (±5%): +12V → 11.40V–12.60V  |  +5V → 4.75V–5.25V  |  +3.3V → 3.14V–3.47V\n• પાવર-ગુડ (PG, ગ્રે વાયર): 5.0V (100–500 ms બૂટ સિગ્નલ)\n• SMPS પાવર ગણતરી: P_rail = V_rail × I_rail",
        equationsHi =
          "• ATX SMPS मानक सीमा (±5%): +12V → 11.40V–12.60V  |  +5V → 4.75V–5.25V  |  +3.3V → 3.14V–3.47V\n• Power-Good (ग्रे वायर): +5.0V (मदरबोर्ड स्टार्ट संकेत)\n• रेल पावर: P = V × I",
        equationsEn =
          "• ATX Rail Tolerance (±5%): +12V (11.4–12.6V)  |  +5V (4.75–5.25V)  |  +3.3V (3.14–3.47V)\n• Power-Good (PG Grey Wire): +5.0V DC (confirms rails stable)\n• Green PS_ON# Pin 16: Short to Black GND to start standalone SMPS",
        impQuestionsGu =
          "Q: SMPS ટેસ્ટ કરવા માટે 'પેપરક્લિપ ટેસ્ટ' કેવી રીતે કરવામાં આવે છે?\nA: 24-પિન ATX કનેક્ટરને મધરબોર્ડથી અલગ કરીને લીલો વાયર (PS_ON# Pin 16) કોઈપણ કાળા (GND) વાયર સાથે જોડવાથી SMPS ફેન ચાલુ થવો જોઈએ.\n---\nQ: PC ટેકનિશિયન માટે ESD કાંડા પટ્ટો કેમ ફરજિયાત છે?\nA: આપણા શરીરનો સ્થિત વીજ ચાર્જ (Static Electricity) RAM કે CPU ની નાજુક IC ને અડતા જ બગાડી શકે છે.\n---\nQ: ATX SMPS માં +12V (પીળો), +5V (લાલ), +3.3V (નારંગી) વાયર શા માટે વપરાય છે?\nA: +12V CPU VRM અને ફેન મોટર્સને, +5V USB પોર્ટ્સને અને +3.3V ચિપસેટ/મેમરીને પાવર આપે છે.",
        impQuestionsHi =
          "Q: ATX SMPS का पेपरक्लिप टेस्ट कैसे करते हैं?\nA: मदरबोर्ड से 24-पिन केबल निकालकर हरे तार (PS_ON#) को काले तार (GND) से जोड़ने पर SMPS का फैन चलना चाहिए।\n---\nQ: ESD (Electrostatic Discharge) से कंप्यूटर पुर्जों को कैसे बचाएं?\nA: एंटी-स्टैटिक रिस्ट स्ट्रैप पहनकर और मदरबोर्ड/RAM को केवल किनारों से पकड़कर।\n---\nQ: ATX तारों के रंग कोड क्या हैं?\nA: पीला = +12V, लाल = +5V, नारंगी = +3.3V, काला = 0V (GND), बैंगनी = +5VSB।",
        impQuestionsEn =
          "Q: How is a standalone ATX SMPS Paperclip Test performed safely?\nA: Unplug all motherboard/drive cables, jumper Green (PS_ON# Pin 16) to any Black (GND), switch AC ON, and probe rails with DMM.\n---\nQ: What are the standard ATX wire color voltages?\nA: Yellow = +12V, Red = +5V, Orange = +3.3V, Black = GND, Purple = +5VSB, Grey = Power-Good (+5V).\n---\nQ: Why must technicians wear an ESD wrist strap when handling RAM or CPUs?\nA: Static shocks (<3000V, invisible to humans) permanently damage CMOS micro-transistors inside CPUs and RAM.",
        rememberTipGu = "SMPS નું મેટલ બોક્સ ક્યારેય ખોલશો નહીં — અંદરના મોટા કેપેસિટરમાં પ્લગ કાઢ્યા પછી પણ 300V+ ચાર્જ રહે છે!",
        rememberTipHi = "SMPS का केस कभी न खोलें; बाहर से 24-पिन कनेक्टर पर ही DMM से वोल्टेज मापें।",
        rememberTipEn = "Never open an SMPS metal enclosure—primary capacitors retain hazardous 320V+ DC even unplugged!",
        glossaryGu = "SMPS: સ્વિચ્ડ-મોડ પાવર સપ્લાય • ESD: સ્થિત વીજ વિસર્જન • PS_ON#: પાવર ચાલુ સિગ્નલ",
        glossaryHi = "SMPS: स्विच्ड-मोड पावर सप्लाई • ESD: इलेक्ट्रोस्टैटिक डिस्चार्ज • VRM: वोल्टेज रेगुलेटर मॉड्यूल",
        glossaryEn = "ATX 24-Pin • ESD: Electrostatic Discharge • +5VSB: 5V Standby Rail",
        circuitDiagramId = "circuit_computer_block",
        linkedPracticalId = "prac_11_3",
        estimatedMinutes = 15,
        downloadSizeKb = 700,
        isDownloadedOffline = true,
        sortOrder = 9,
      ),

      LessonEntity(
        lessonId = "lesson_11_4",
        classStd = 11,
        chapterCode = "Std 11 • Module 4 (Sessions 1–3)",
        tradeNameGu = TRADE_11_12_GU,
        tradeNameHi = TRADE_11_12_HI,
        tradeNameEn = TRADE_11_12_EN,
        unitTitleGu = "ડેસ્કટોપ કમ્પ્યુટર અને પેરિફેરલ્સનું ઇન્સ્ટોલેશન",
        unitTitleHi = "डेस्कटॉप कंप्यूटर एवं पेरिफेरल्स की स्थापना",
        unitTitleEn = "Installation of Desktop Computer and Peripherals",
        titleGu = "મોડ્યુલ 4: મધરબોર્ડ-CPU ઇન્સ્ટોલેશન, પેરિફેરલ્સ અને PC એસેમ્બલી",
        titleHi = "मॉड्यूल 4: मदरबोर्ड-CPU इंस्टॉलेशन, पेरिफेरल्स और PC असेंबली",
        titleEn = "Module 4: Desktop PC Assembly, Motherboard & CPU Setup",
        summaryGu = "CPU સોકેટ ફિટિંગ, થર્મલ પેસ્ટ, RAM અને SSD ઇન્સ્ટોલ, ફ્રન્ટ પેનલ હેડર વાયરિંગ અને PC એસેમ્બલી/ડિસ્મેન્ટલ.",
        summaryHi = "CPU सॉकेट फिटिंग, थर्मल पेस्ट, RAM-SSD इंस्टॉलेशन, फ्रंट पैनल वायरिंग और डेस्कटॉप असेंबली।",
        summaryEn = "Installing motherboard & CPU, internal/external peripherals, front-panel headers, and full PC assembly/dismantling.",
        learningOutcomesGu =
          "• મધરબોર્ડ સ્ટેન્ડઓફ્સ લગાવી CPU, થર્મલ પેસ્ટ અને કૂલર સુરક્ષિત રીતે ફિટ કરવો.\n• RAM, SSD/HDD, 24-પિન ATX, 4/8-પિન CPU પાવર અને ફ્રન્ટ પેનલ કેબલ્સ જોડવા.\n• ડેસ્કટોપ કમ્પ્યુટરને સંપૂર્ણ એસેમ્બલ અને ડિસ્મેન્ટલ કરીને POST બૂટ તપાસવું.",
        learningOutcomesHi =
          "• मदरबोर्ड पर CPU, थर्मल पेस्ट, कूलर और RAM मॉड्यूल सही दिशा से लगाना।\n• आंतरिक (SSD/SMPS/फ्रंट पैनल) और बाहरी (मॉनिटर/कीबोर्ड) पेरिफेरल्स जोड़ना।\n• डेस्कटॉप PC को क्रमबद्ध असेंबल व डिसमेंटल कर POST टेस्ट करना।",
        learningOutcomesEn =
          "• Install CPU (triangle alignment), thermal paste, cooler, and RAM onto the motherboard.\n• Connect internal drives, ATX/EPS power, front-panel headers, and external peripherals.\n• Safely assemble and dismantle a complete desktop computer.",
        bodyGu =
          "📌 સેશન 1 — મધરબોર્ડ અને CPU: કેબિનેટમાં બ્રાસ સ્ટેન્ડઓફ્સ લગાવો (શોર્ટ અટકાવવા). CPU ના ખૂણાનું સોનેરી ત્રિકોણ સોકેટના ત્રિકોણ સાથે મેળવીને ZIF લીવર બંધ કરો. વટાણા જેટલી થર્મલ પેસ્ટ લગાવી કૂલર ફિટ કરો.\n\n📌 સેશન 2 — આંતરિક અને બાહ્ય પેરિફેરલ્સ: RAM ને નોચ મેળવી ક્લિક થાય ત્યાં સુધી દબાવો. SATA SSD, 24-પિન ATX, 4/8-પિન CPU પાવર અને ફ્રન્ટ પેનલ (`PWR_SW`, `RESET_SW`, `HDD_LED`) જોડો. બહારથી HDMI/VGA, USB કીબોર્ડ/માઉસ લગાવો.\n\n📌 સેશન 3 — એસેમ્બલ અને ડિસ્મેન્ટલ: ડિસ્મેન્ટલ કરતી વખતે ઊલટો ક્રમ (પાવર કોર્ડ → બાહ્ય કેબલ્સ → RAM/SSD → SMPS → મધરબોર્ડ) અનુસરો.",
        bodyHi =
          "📌 सत्र 1 — मदरबोर्ड और CPU: कैबिनेट में पीतल के स्टैंडऑफ लगाएं। CPU के सुनहरे त्रिकोण को सॉकेट से मिलाकर रखें, मटर के दाने जितनी थर्मल पेस्ट लगाएं और कूलर कसें।\n\n📌 सत्र 2 — पेरिफेरल्स जोड़ना: RAM स्लॉट में क्लिक होने तक दबाएं। SSD, 24-पिन ATX, CPU पावर और फ्रंट पैनल हेडर (`PWR_SW`, `RESET_SW`) तथा बाहर मॉनिटर व कीबोर्ड जोड़ें।\n\n📌 सत्र 3 — असेंबली और डिसमेंटल: पहले बाहर की केबल, फिर RAM/स्टोरेज, SMPS और अंत में मदरबोर्ड निकालें।",
        bodyEn =
          "📌 Session 1 — Motherboard & CPU: Mount brass standoffs matching motherboard holes (prevents underside shorts). Align golden Pin-1 triangle on CPU to socket, latch gently, apply pea-sized thermal paste, and mount cooler.\n\n📌 Session 2 — Internal & External Peripherals: Seat RAM until latches click, mount SSD, plug 24-pin ATX + 4/8-pin EPS CPU power + front-panel headers (`PWR_SW`, `HDD_LED`), and attach external display/USB peripherals.\n\n📌 Session 3 — Assemble & Dismantle: Follow reverse order on dismantling and use labeled screw trays.",
        equationsGu =
          "• મધરબોર્ડ ફોર્મ ફેક્ટર: ATX (305×244 mm)  |  Micro-ATX (244×244 mm)  |  Mini-ITX (170×170 mm)\n• CPU થર્મલ પેસ્ટ: ~4 mm વટાણા જેટલું બિંદુ (વધુ પડતું લગાવવાથી બહાર ફેલાય છે)\n• ડ્યુઅલ-ચેનલ RAM સ્લોટ: સામાન્ય રીતે A2 + B2 (સ્લોટ 2 અને 4)",
        equationsHi =
          "• मदरबोर्ड आकार: ATX (305×244 mm)  |  Micro-ATX (244×244 mm)  |  Mini-ITX (170×170 mm)\n• थर्मल पेस्ट मात्रा: केंद्र में मटर के दाने जितना (~4 mm बिंदु)\n• डुअल-चैनल RAM: आमतौर पर स्लॉट A2 + B2",
        equationsEn =
          "• Form Factors: ATX (305×244 mm)  |  Micro-ATX (244×244 mm)  |  Mini-ITX (170×170 mm)\n• Thermal Paste Rule: Single ~4 mm pea-sized dot at IHS center\n• Dual-Channel RAM Slots: Typically Slots 2 & 4 (A2 + B2)",
        impQuestionsGu =
          "Q: મધરબોર્ડ લગાવતા પહેલાં કેબિનેટમાં બ્રાસ સ્ટેન્ડઓફ્સ કેમ લગાવવા જરૂરી છે?\nA: જો મધરબોર્ડની પાછળની બાજુ મેટલ કેબિનેટને સીધી અડે તો પાવર શોર્ટ સર્કિટ થઈને મધરબોર્ડ બળી જાય છે.\n---\nQ: CPU કૂલર લગાવતા પહેલાં થર્મલ પેસ્ટ કેમ લગાવવામાં આવે છે?\nA: CPU અને હીટ-સિંક વચ્ચેના સૂક્ષ્મ હવાના ખાડા ભરીને ગરમી ઝડપથી હીટ-સિંક સુધી પહોંચાડવા માટે.\n---\nQ: જો PC ચાલુ બટન દબાવતા ચાલુ ન થાય તો ફ્રન્ટ પેનલમાં કયો પિન ચેક કરશો?\nA: મધરબોર્ડના `F_PANEL` હેડર પર `PWR_SW` કેબલ યોગ્ય પિન પર છે કે નહીં તે તપાસવું.",
        impQuestionsHi =
          "Q: मदरबोर्ड लगाते समय पीतल के स्टैंडऑफ (Standoffs) क्यों आवश्यक हैं?\nA: यह मदरबोर्ड की निचली सोल्डर पिन को धातु कैबिनेट से दूर रखकर शॉर्ट सर्किट से बचाते हैं।\n---\nQ: थर्मल पेस्ट लगाने का क्या उद्देश्य है?\nA: CPU और हीट-सिंक के बीच हवा की सूक्ष्म जगह भरकर बेहतर ऊष्मा स्थानांतरण करना।\n---\nQ: 24-पिन के अलावा CPU के पास 4/8-पिन पावर केबल क्यों लगाई जाती है?\nA: यह प्रोसेसर VRM को समर्पित +12V पावर प्रदान करती है; इसके बिना PC डिस्प्ले नहीं देगा।",
        impQuestionsEn =
          "Q: Why are brass standoffs mandatory before screwing down a motherboard?\nA: They elevate the PCB above the metal chassis so underside solder pins do not short to ground.\n---\nQ: What happens if you forget the 4/8-pin EPS CPU power cable near the processor?\nA: Fans may spin briefly, but the CPU VRM gets no +12V power and the system fails POST with no display.\n---\nQ: Why install matching RAM sticks in Dual-Channel slots (A2+B2)?\nA: Doubles memory bus width (128-bit vs 64-bit) for faster system performance.",
        rememberTipGu = "ક્યારેય વધારાના બ્રાસ સ્ટેન્ડઓફ્સ મધરબોર્ડની નીચે બિનજરૂરી જગ્યાએ ન છોડો — શોર્ટ થઈ શકે!",
        rememberTipHi = "मदरबोर्ड के छेदों से मेल खाने वाले स्थानों पर ही स्टैंडऑफ लगाएं, अतिरिक्त स्टैंडऑफ हटा दें।",
        rememberTipEn = "Match standoff count 1-to-1 with motherboard screw holes; extra standoffs underneath cause shorts!",
        glossaryGu = "ZIF સોકેટ: શૂન્ય બળ ઇન્સર્શન સોકેટ • F_PANEL: ફ્રન્ટ પાવર/રીસેટ પિન્સ • IHS: CPU હીટ સ્પ્રેડર",
        glossaryHi = "ZIF सॉकेट: जीरो इंसर्शन फोर्स सॉकेट • F_PANEL: फ्रंट स्विच हेडर • पोस्ट (POST)",
        glossaryEn = "Standoffs: Brass PCB spacers • EPS 8-Pin: CPU +12V cable • F_PANEL: Case switch header",
        circuitDiagramId = "circuit_computer_block",
        linkedPracticalId = "prac_11_4",
        estimatedMinutes = 16,
        downloadSizeKb = 750,
        isDownloadedOffline = true,
        sortOrder = 10,
      ),

      // ==================== GRADE XII ====================
      LessonEntity(
        lessonId = "lesson_12_1",
        classStd = 12,
        chapterCode = "Std 12 • Module 1 (Sessions 1–4)",
        tradeNameGu = TRADE_11_12_GU,
        tradeNameHi = TRADE_11_12_HI,
        tradeNameEn = TRADE_11_12_EN,
        unitTitleGu = "ડેસ્કટોપ કમ્પ્યુટર અને પેરિફેરલ્સનું રિપેરિંગ અને જાળવણી",
        unitTitleHi = "डेस्कटॉप कंप्यूटर एवं पेरिफेरल्स की मरम्मत व रखरखाव",
        unitTitleEn = "Repair and Maintenance of Desktop Computer and Peripherals",
        titleGu = "મોડ્યુલ 1: ડેસ્કટોપ અને પેરિફેરલ ફોલ્ટ નિદાન, નિવારક જાળવણી અને રિપોર્ટ",
        titleHi = "मॉड्यूल 1: डेस्कटॉप हार्डवेयर-सॉफ्टवेयर दोष, प्रिवेंटिव मेंटेनेंस व वर्क रिपोर्ट",
        titleEn = "Module 1: Desktop & Peripheral Repair, Diagnostics & Report",
        summaryGu = "પેરિફેરલ્સ રિપેર, POST બીપ કોડ/BSOD, ડિસએસેમ્બલી અને નિવારક જાળવણી તથા ગ્રાહક વર્ક રિપોર્ટ.",
        summaryHi = "पेरिफेरल्स मरम्मत, POST बीप कोड/BSOD, प्रिवेंटिव मेंटेनेंस और पोस्ट-रिपेयर वर्क रिपोर्ट।",
        summaryEn = "Peripheral servicing, hardware/software diagnostics (POST/BSOD), preventive maintenance & work reports.",
        learningOutcomesGu =
          "• કીબોર્ડ, માઉસ, મોનિટર અને પ્રિન્ટરના સામાન્ય ફોલ્ટ (પેપર જામ, નો-સિગ્નલ) સુધારવા.\n• POST બીપ કોડ, નો-ડિસ્પ્લે, BSOD અને સ્લો PC ની સમસ્યાનું નિદાન કરવું.\n• સુરક્ષિત ડિસએસેમ્બલી, ધૂળ સફાઈ, રિપેર પછીનું ટેસ્ટિંગ અને વર્ક રિપોર્ટ તૈયાર કરવો.",
        learningOutcomesHi =
          "• कीबोर्ड, माउस, मॉनिटर और प्रिंटर के सामान्य दोषों की मरम्मत करना।\n• हार्डवेयर (RAM, SMPS) व सॉफ्टवेयर (BSOD, ड्राइवर) समस्याओं का निदान करना।\n• प्रिवेंटिव मेंटेनेंस और रिपेयर के बाद वर्क रिपोर्ट व फीडबैक लेना।",
        learningOutcomesEn =
          "• Repair common computer peripheral faults (printers, monitors, input devices).\n• Diagnose hardware/software issues (No POST, beep codes, BSOD, overheating).\n• Perform preventive maintenance and prepare post-repair test & customer reports.",
        bodyGu =
          "📌 સેશન 1 — પેરિફેરલ્સ રિપેર: લેસર પ્રિન્ટરમાં પેપર જામ, ફ્યુઝર/ટોનર, મોનિટર કેબલ/બેકલાઇટ ચેક અને USB પોર્ટ તપાસ.\n\n📌 સેશન 2 — હાર્ડવેર અને સોફ્ટવેર સમસ્યાઓ: PC ચાલુ થાય પણ ડિસ્પ્લે ન આવે → RAM કાઢી ગોલ્ડ પિન્સ રબર/IPA થી સાફ કરો અને SMPS વોલ્ટેજ તપાસો. BSOD (Blue Screen) માટે સ્ટોરેજ સ્માર્ટ હેલ્થ અને ડ્રાઇવર તપાસો.\n\n📌 સેશન 3 — નિવારક જાળવણી (Preventive Maintenance): એર બ્લોઅરથી ધૂળ સફાઈ, ફેન ઓઇલિંગ, થર્મલ પેસ્ટ રિન્યૂ અને કેબલ મેનેજમેન્ટ.\n\n📌 સેશન 4 — પોસ્ટ-રિપેર ફંક્શનાલિટી અને વર્ક રિપોર્ટ: ઓછામાં ઓછી 15 મિનિટ સ્ટ્રેસ/બર્ન-ઇન ટેસ્ટ, ચેકલિસ્ટ, ગ્રાહક હસ્તાક્ષર અને ફીડબેક.",
        bodyHi =
          "📌 सत्र 1 — पेरिफेरल रिपेयर: प्रिंटर पेपर जैम व रोलर सफाई, मॉनिटर केबल और पोर्ट की जांच।\n\n📌 सत्र 2 — हार्डवेयर व सॉफ्टवेयर दोष: नो-डिस्प्ले होने पर RAM के कॉन्टैक्ट IPA/इरेज़र से साफ करें और CMOS व SMPS जांचें। BSOD में ड्राइवर/SSD चेक करें।\n\n📌 सत्र 3 — प्रिवेंटिव मेंटेनेंस: नियमित धूल सफाई, फैन जांच, थर्मल पेस्ट बदलना और एंटीवायरस अपडेट।\n\n📌 सत्र 4 — पोस्ट-रिपेयर टेस्ट व वर्क रिपोर्ट: 15 मिनट टेस्टिंग के बाद ग्राहक के सामने सभी पोर्ट जांचकर कार्य रिपोर्ट पर हस्ताक्षर लें।",
        bodyEn =
          "📌 Session 1 — Peripheral Maintenance: Clear printer roller/paper jams, check monitor signal cables, test USB keyboard/mouse.\n\n📌 Session 2 — Hardware & Software Issues: No Display / POST Beeps → clean RAM gold pins with IPA, reset CMOS, check SMPS. BSOD → check RAM/SSD SMART status and corrupt drivers.\n\n📌 Session 3 — Disassembly & Preventive Maintenance: Dust removal via air blower, heatsink repasting, fan cleaning, disk cleanup.\n\n📌 Session 4 — Post-Repair Testing & Work Report: Verify audio/USB/LAN/display stability, complete service report & collect customer feedback.",
        equationsGu =
          "• નિવારક જાળવણી અંતરાલ: ધૂળ સફાઈ = દર 3–6 મહિને  |  થર્મલ પેસ્ટ = દર 12–18 મહિને\n• સલામત CPU તાપમાન: Idle 35–48°C  |  Load < 80°C  (>95°C પર Thermal Throttling)\n• POST સંકેત: 1 Short Beep = OK  |  Continuous/3 Beeps = RAM Fault",
        equationsHi =
          "• मेंटेनेंस अंतराल: धूल सफाई = 3–6 माह  |  थर्मल पेस्ट = 12–18 माह\n• सुरक्षित CPU तापमान: Idle 35–48°C  |  Load < 80°C  (>95°C = ओवरहीटिंग)\n• POST बीप: 1 छोटी बीप = सब ठीक  |  लगातार बीप = RAM/पावर दोष",
        equationsEn =
          "• Maintenance Cycle: Dust blowout = 3–6 months  |  Thermal paste = 12–18 months\n• Safe CPU Temp: Idle 35–48°C  |  Full Load < 80°C  (>95°C = Throttling)\n• POST Code Rule: 1 Short Beep = Pass  |  Repeated Long Beeps = RAM / Video Fault",
        impQuestionsGu =
          "Q: PC ચાલુ થાય, ફેન ફરે પણ મોનિટર પર કોઈ ડિસ્પ્લે ન આવે તો પ્રથમ 3 પગલાં કયા લેશો?\nA: (1) VGA/HDMI કેબલ અને મોનિટર ઇનપુટ ચેક, (2) RAM કાઢી ગોલ્ડ પિન્સ IPA/ઇરેઝરથી સાફ કરી ફરી લગાવવી, (3) CMOS બેટરી (3V) અને SMPS વોલ્ટેજ માપવો.\n---\nQ: નિવારક જાળવણી (Preventive Maintenance) નો મુખ્ય ફાયદો શું છે?\nA: અચાનક હાર્ડવેર ફેલ્યોર, ઓવરહીટિંગ અને ડેટા નુકસાન અગાઉથી અટકાવી શકાય છે.\n---\nQ: રિપેર પછી વર્ક રિપોર્ટ અને ગ્રાહક ફીડબેક કેમ જરૂરી છે?\nA: બદલાયેલા ભાગો, વોરંટી, ટેસ્ટ પરિણામ અને ગ્રાહક સંતોષનો સત્તાવાર રેકોર્ડ રાખવા માટે.",
        impQuestionsHi =
          "Q: कंप्यूटर ऑन होने और फैन चलने पर भी डिस्प्ले न आए तो क्या जांचेंगे?\nA: (1) डिस्प्ले केबल, (2) RAM निकालकर कॉन्टैक्ट साफ करना व दूसरे स्लॉट में लगाना, (3) CMOS 3V बैटरी और SMPS वोल्टेज चेक।\n---\nQ: BSOD (Blue Screen of Death) आने के मुख्य कारण क्या हैं?\nA: खराब RAM सेक्टर, फॉल्टी SSD/HDD, या असंगत (Corrupt) डिवाइस ड्राइवर।\n---\nQ: पोस्ट-रिपेयर वर्क रिपोर्ट में क्या लिखा जाता है?\nA: समस्या विवरण, बदला गया पार्ट, परीक्षण परिणाम, शुल्क और ग्राहक के हस्ताक्षर।",
        impQuestionsEn =
          "Q: A desktop powers ON and fans spin, but there is NO display. List the first 3 diagnostic checks.\nA: (1) Verify monitor & HDMI/VGA cable, (2) Reseat/clean RAM gold contacts with IPA, (3) Test CMOS 3V battery and SMPS rails.\n---\nQ: What is Preventive Maintenance in computer servicing?\nA: Scheduled cleaning, thermal paste renewal, cable checks, and OS/antivirus updates to prevent failures before they occur.\n---\nQ: Why must a technician prepare a Post-Repair Work Report?\nA: Documents diagnosed fault, parts replaced, verification test pass status, and customer sign-off.",
        rememberTipGu = "ક્યારેય મધરબોર્ડ કે RAM સાફ કરવા સાદું પાણી કે પેટ્રોલ ન વાપરો — માત્ર 99% Isopropyl Alcohol (IPA) વાપરો!",
        rememberTipHi = "सर्किट या RAM पिन साफ करने के लिए केवल 99% Isopropyl Alcohol (IPA) उपयोग करें, पानी नहीं!",
        rememberTipEn = "Clean PCB contacts strictly with 99% Isopropyl Alcohol (IPA) and lint-free swabs—never water!",
        glossaryGu = "POST: પાવર-ઓન સેલ્ફ ટેસ્ટ • BSOD: બ્લુ સ્ક્રીન એરર • IPA: આઇસોપ્રોપાઇલ આલ્કોહોલ",
        glossaryHi = "POST: पावर-ऑन सेल्फ टेस्ट • BSOD: ब्लू स्क्रीन ऑफ डेथ • थर्मल थ्रॉटलिंग",
        glossaryEn = "POST: Power-On Self-Test • BSOD • Preventive Maintenance • Burn-in Test",
        circuitDiagramId = "circuit_computer_block",
        linkedPracticalId = "prac_12_1",
        estimatedMinutes = 16,
        downloadSizeKb = 720,
        isDownloadedOffline = true,
        sortOrder = 11,
      ),

      LessonEntity(
        lessonId = "lesson_12_2",
        classStd = 12,
        chapterCode = "Std 12 • Module 2 (Sessions 1–5)",
        tradeNameGu = TRADE_11_12_GU,
        tradeNameHi = TRADE_11_12_HI,
        tradeNameEn = TRADE_11_12_EN,
        unitTitleGu = "લેપટોપ અને પેરિફેરલ્સનું ઇન્સ્ટોલેશન અને કન્ફિગરેશન",
        unitTitleHi = "लैपटॉप और पेरिफेरल्स की स्थापना एवं कॉन्फ़िगरेशन",
        unitTitleEn = "Installation and Configuration of Laptop and Peripherals",
        titleGu = "મોડ્યુલ 2: લેપટોપ સેટઅપ, મધરબોર્ડ-CPU-SODIMM RAM અને ડિસએસેમ્બલી",
        titleHi = "मॉड्यूल 2: लैपटॉप सेटअप, मदरबोर्ड, CPU, SODIMM RAM और असेंबली",
        titleEn = "Module 2: Laptop Hardware, Motherboard, CPU & SODIMM RAM",
        summaryGu = "લેપટોપ સેટિંગ્સ, મધરબોર્ડ/CPU/SODIMM RAM ઇન્સ્ટોલેશન, ZIF રિબન કેબલ અને સુરક્ષિત એસેમ્બલી/ડિસ્મેન્ટલ.",
        summaryHi = "लैपटॉप सेटअप, मदरबोर्ड, प्रोसेसर, SODIMM RAM इंस्टॉलेशन और सुरक्षित डिसअसेंबली।",
        summaryEn = "Laptop initial setup, laptop motherboard, mobile CPU, SODIMM RAM upgrade, and ZIF disassembly.",
        learningOutcomesGu =
          "• નવા લેપટોપનું પ્રથમ સેટઅપ, બેટરી કેલિબ્રેશન અને પાવર પ્લાન કન્ફિગર કરવા.\n• લેપટોપ મધરબોર્ડ, પ્રોસેસર/હીટ-પાઇપ અને SODIMM RAM મોડ્યુલ ઇન્સ્ટોલ કરવા.\n• મેગ્નેટિક સ્ક્રૂ મેપ સાથે લેપટોપ સુરક્ષિત રીતે ખોલવું અને ફરી જોડવું.",
        learningOutcomesHi =
          "• लैपटॉप का शुरुआती सेटअप, पावर प्लान और पेरिफेरल कॉन्फ़िगरेशन करना।\n• लैपटॉप मदरबोर्ड, CPU कूलिंग असेंबली और SODIMM RAM मॉड्यूल लगाना।\n• बिना केबल या पैनल तोड़े लैपटॉप को सुरक्षित असेंबल व डिसअसेंबल करना।",
        learningOutcomesEn =
          "• Configure laptop setup, power profiles, Wi-Fi/Bluetooth & external peripherals.\n• Install laptop motherboard, cooling heat-pipe/CPU, and SODIMM RAM modules.\n• Disassemble and reassemble a laptop safely using plastic pry tools and screw maps.",
        bodyGu =
          "📌 સેશન 1 — લેપટોપ સેટિંગ: બેટરી હેલ્થ, પાવર પ્લાન (Balanced/Performance), ટચપેડ અને Wi-Fi/ડ્યુઅલ ડિસ્પ્લે સેટઅપ.\n\n📌 સેશન 2 અને 3 — મધરબોર્ડ અને CPU: ડેસ્કટોપ કરતાં લેપટોપ મધરબોર્ડ ખૂબ નાજુક અને કોમ્પેક્ટ હોય છે. તેમાં 19.5V પરથી VRM બક કન્વર્ટર વડે 3.3V/5V/Vcore બને છે. હીટ-સિંકના સ્ક્રૂ હંમેશા ક્રમવાર (4-3-2-1) ખોલો.\n\n📌 સેશન 4 — SODIMM RAM: લેપટોપમાં નાના કદની SODIMM (260-pin DDR4) RAM વપરાય છે — 30° ખૂણે દાખલ કરી ક્લિક થાય ત્યાં સુધી નીચે દબાવો.\n\n📌 સેશન 5 — એસેમ્બલ/ડિસ્મેન્ટલ: (1) AC અનપ્લગ કરો → (2) બેઝ કવર ખોલો → (3) સૌપ્રથમ Li-Ion બેટરી કનેક્ટર કાઢો → (4) SSD/RAM/ફેન/ZIF રિબન ખોલો.",
        bodyHi =
          "📌 सत्र 1 — लैपटॉप सेटअप: पावर मोड, Wi-Fi, टचपैड और एक्सटर्नल मॉनिटर सेटिंग्स।\n\n📌 सत्र 2 व 3 — लैपटॉप मदरबोर्ड व CPU: लैपटॉप बोर्ड कॉम्पैक्ट होता है जिसमें 19.5V से VRM द्वारा Vcore व 3.3V/5V बनते हैं। हीट-पाइप स्क्रू नंबर क्रम में खोलें।\n\n📌 सत्र 4 — SODIMM RAM लगाना: स्लॉट में 30° कोण पर लगाकर नीचे दबाएं जब तक दोनों क्लिप लॉक न हों।\n\n📌 सत्र 5 — डिसअसेंबली नियम: बॉटम कवर खोलने के तुरंत बाद सबसे पहले बैटरी कनेक्टर (BAT) हटाएं, तभी कोई केबल या RAM छुएं।",
        bodyEn =
          "📌 Session 1 — Laptop Setup: Initial OS/power plan setup, touchpad gestures, Wi-Fi, and docking/HDMI display configuration.\n\n📌 Sessions 2 & 3 — Motherboard & CPU/Thermal: Compact PCBs use buck VRM stages (19.5V → 5V/3.3V/Vcore). Unscrew copper heat-pipes in numbered order to avoid cracking bare CPU dies.\n\n📌 Session 4 — Install SODIMM RAM: Insert compact SODIMM at a 30° angle and press down until both side metal clips lock.\n\n📌 Session 5 — Assemble & Dismantle: Always disconnect the Li-Ion battery connector FIRST after removing the bottom panel; map screw lengths.",
        equationsGu =
          "• લેપટોપ એડેપ્ટર પાવર: Watt = V_out × I_out  (દા.ત. 19.5V × 3.34A = 65.1 W)\n• RAM પ્રકાર વોલ્ટેજ: DDR3L = 1.35V  |  DDR4 SODIMM = 1.2V  |  DDR5 SODIMM = 1.1V\n• SODIMM ખૂણો: સ્લોટ ઇન્સર્શન એંગલ = 30° થી 45°",
        equationsHi =
          "• लैपटॉप एडॉप्टर पावर: Watt = V_out × I_out  (उदा. 19.5V × 3.34A = 65 W)\n• SODIMM वोल्टेज: DDR3L = 1.35V  |  DDR4 = 1.2V  |  DDR5 = 1.1V\n• RAM लगाने का कोण: 30°–45°",
        equationsEn =
          "• Adapter Wattage: P = V × I  (e.g., 19.5V × 3.34A = 65W; never under-watt)\n• SODIMM Voltages: DDR3L = 1.35V  |  DDR4 = 1.2V  |  DDR5 = 1.1V\n• Insertion Angle: 30°–45° into SODIMM socket until side clips snap",
        impQuestionsGu =
          "Q: લેપટોપ ખોલતા જ સૌપ્રથમ બેટરી કનેક્ટર અલગ કરવું કેમ ફરજિયાત છે?\nA: જો બેટરી જોડાયેલી હોય અને સ્ક્રુડ્રાઇવર કે ડિસ્પ્લે eDP કેબલ અડી જાય તો 19V/11V થી મધરબોર્ડ અને LCD બેકલાઇટ IC તરત બળી શકે છે.\n---\nQ: ડેસ્કટોપ DIMM અને લેપટોપ SODIMM RAM વચ્ચે શું તફાવત છે?\nA: DIMM લાંબી (288-પિન DDR4) હોય છે, જ્યારે SODIMM નાની (260-પિન) હોય છે જે 30° ખૂણે લાગે છે.\n---\nQ: લેપટોપમાં હીટ-સિંકના સ્ક્રૂ નંબર (1-2-3-4) પ્રમાણે જ કેમ કસવા જોઈએ?\nA: લેપટોપ CPU પર મેટલ કવર (IHS) હોતું નથી — અસમાન દબાણથી સિલિકોન ડાય તૂટી શકે છે.",
        impQuestionsHi =
          "Q: लैपटॉप डिसअसेंबल करते समय सबसे पहले बैटरी कनेक्टर क्यों हटाना चाहिए?\nA: बैटरी जुड़े रहने पर eDP केबल या स्क्रूड्राइवर लगने से मदरबोर्ड की पावर रेल और डिस्प्ले IC शॉर्ट हो सकती है।\n---\nQ: डेस्कटॉप RAM (DIMM) और लैपटॉप RAM (SODIMM) में क्या अंतर है?\nA: SODIMM आकार में छोटी (260-पिन DDR4) होती है और लैपटॉप स्लॉट में 30° कोण पर लगती है।\n---\nQ: ZIF रिबन केबल (कीबोर्ड/टचपैड) खोलने का सही तरीका क्या है?\nA: प्लास्टिक स्पजर से छोटे फ्लिप-लैच को हल्के से ऊपर उठाकर केबल सीधा बाहर निकालें।",
        impQuestionsEn =
          "Q: Why must the internal battery be unplugged BEFORE touching the eDP display cable or RAM?\nA: Live standby power on the board will short the backlight fuse or PCH if a display cable is unplugged live.\n---\nQ: What is the difference between Desktop DIMM and Laptop SODIMM?\nA: SODIMM (Small Outline DIMM) is roughly half the length (260-pin DDR4 vs 288-pin DIMM) and seats at 30°.\n---\nQ: Why unscrew/tighten laptop heatsink screws in numbered diagonal sequence?\nA: Bare mobile CPU dies lack an IHS lid; diagonal numbering ensures even pressure without cracking the die.",
        rememberTipGu = "ક્યારેય અલગ-અલગ લંબાઈના લેપટોપ સ્ક્રૂ ભેગા ન કરો — મેગ્નેટિક મેટ અથવા કાગળ પર લેઆઉટ દોરીને મૂકો!",
        rememberTipHi = "लैपटॉप के स्क्रू अलग-अलग लंबाई के होते हैं; लंबे स्क्रू गलत छेद में कसने से कीबोर्ड पामरेस्ट में छेद हो सकता है!",
        rememberTipEn = "Always map laptop screw lengths! Putting a long bottom screw into a short palmrest boss damages the case.",
        glossaryGu = "SODIMM: સ્મોલ આઉટલાઇન DIMM • ZIF કેબલ: ફ્લેટ રિબન કેબલ • eDP: લેપટોપ ડિસ્પ્લે પોર્ટ",
        glossaryHi = "SODIMM: लैपटॉप RAM • ZIF लैच: रिबन केबल लॉक • VRM: वोल्टेज स्टेप-डाउन स्टेज",
        glossaryEn = "SODIMM • ZIF Ribbon Latch • eDP Display Cable • Plastic Spudger",
        circuitDiagramId = "circuit_laptop_power",
        linkedPracticalId = "prac_12_2",
        estimatedMinutes = 16,
        downloadSizeKb = 760,
        isDownloadedOffline = true,
        sortOrder = 12,
      ),

      LessonEntity(
        lessonId = "lesson_12_3",
        classStd = 12,
        chapterCode = "Std 12 • Module 3 (Sessions 1–4)",
        tradeNameGu = TRADE_11_12_GU,
        tradeNameHi = TRADE_11_12_HI,
        tradeNameEn = TRADE_11_12_EN,
        unitTitleGu = "લેપટોપ અને પેરિફેરલ્સનું રિપેરિંગ અને જાળવણી",
        unitTitleHi = "लैपटॉप और पेरिफेरल्स की मरम्मत और रखरखाव",
        unitTitleEn = "Repair and Maintenance of Laptop and Peripherals",
        titleGu = "મોડ્યુલ 3: લેપટોપ ફોલ્ટ નિદાન, ટેસ્ટિંગ, વર્ક રિપોર્ટ અને ઇન્વોઇસ",
        titleHi = "मॉड्यूल 3: लैपटॉप फॉल्ट रिपेयर, टेस्टिंग, कस्टमर फीडबैक व इनवॉइस",
        titleEn = "Module 3: Laptop Troubleshooting, Testing & Service Billing",
        summaryGu = "લેપટોપ હાર્ડવેર-સોફ્ટવેર ફોલ્ટ, હિંજ/કીબોર્ડ/એડેપ્ટર રિપેર, પોસ્ટ-રિપેર ટેસ્ટિંગ અને વર્ક રિપોર્ટ/ઇન્વોઇસ.",
        summaryHi = "लैपटॉप हार्डवेयर-सॉफ्टवेयर समस्याएं, मेंटेनेंस, रिपेयर टेस्टिंग और वर्क रिपोर्ट व बिलिंग।",
        summaryEn = "Laptop hardware/software faults, maintenance workflow, repaired device stress testing, and invoicing.",
        learningOutcomesGu =
          "• લેપટોપના નો-પાવર, ચાર્જિંગ એરર, ઓવરહીટિંગ, કીબોર્ડ/હિંજ અને OS ફોલ્ટ ઉકેલવા.\n• લેપટોપ જાળવણી (વેન્ટ ક્લિનિંગ, બેટરી હેલ્થ, BIOS અપડેટ) કરવી.\n• રિપેર પછીનું પૂર્ણ ફંક્શનલ ટેસ્ટિંગ કરી સચોટ વર્ક રિપોર્ટ અને ઇન્વોઇસ બનાવવું.",
        learningOutcomesHi =
          "• लैपटॉप के नो-पावर, चार्जिंग, ओवरहीटिंग, हिंज और सॉफ्टवेयर दोष ठीक करना।\n• लैपटॉप मेंटेनेंस प्रक्रिया (बैटरी, फैन, पोर्ट) का पालन करना।\n• रिपेयर के बाद सभी फंक्शन टेस्ट कर ग्राहक को कार्य रिपोर्ट और इनवॉइस देना।",
        learningOutcomesEn =
          "• Diagnose laptop no-power, battery not charging, thermal shutdown, hinge & OS faults.\n• Execute laptop preventive maintenance and BIOS/driver updates safely.\n• Run complete post-repair checklists and generate accurate work reports & invoices.",
        bodyGu =
          "📌 સેશન 1 — લેપટોપ ફોલ્ટ્સ: એડેપ્ટર 19.5V આઉટપુટ DMM થી તપાસો; બેટરી ચાર્જ ન થાય → ચાર્જર IC/બેટરી હેલ્થ; ઓવરહીટ થઈ બંધ થાય → બ્લોઅર ફેન વેન્ટ્સ સાફ કરી થર્મલ પેસ્ટ બદલો; અમુક કી કામ ન કરે → કીબોર્ડ ZIF કેબલ રીસીટ કરો.\n\n📌 સેશન 2 — મેઇન્ટેનન્સ પ્રક્રિયા: હીટ-સિંક ફિન્સ સાફ કરવી, હિંજ સ્ક્રૂ ટાઇટ કરવા, USB/HDMI પોર્ટ્સ IPA થી સાફ કરવા.\n\n📌 સેશન 3 — રિપેર થયેલ લેપટોપનું ટેસ્ટિંગ: એડેપ્ટર અને બેટરી બંને પર બૂટ, કીબોર્ડ/ટચપેડ ટેસ્ટ, સ્પીકર/માઇક/વેબકેમ, Wi-Fi, USB, અને ચાર્જિંગ ટકાવારી ચેક.\n\n📌 સેશન 4 — વર્ક રિપોર્ટ, ફીડબેક અને ઇન્વોઇસ: પાર્ટ કોસ્ટ + લેબર ચાર્જ + GST/વોરંટી વિગતો સાથે પારદર્શક બિલ અને ગ્રાહક ફીડબેક.",
        bodyHi =
          "📌 सत्र 1 — लैपटॉप समस्याएं: DMM से 19.5V एडॉप्टर जांचें; ओवरहीटिंग पर ब्लोअर वेंट साफ करें; कीबोर्ड/टचपैड खराब होने पर रिबन केबल चेक करें।\n\n📌 सत्र 2 — मेंटेनेंस प्रक्रिया: हिंज स्क्रू कसना, कूलिंग वेंट की धूल हटाना और पोर्ट सफाई।\n\n📌 सत्र 3 — पोस्ट-रिपेयर टेस्टिंग: बैटरी चार्जिंग, कीबोर्ड कीज़, कैमरा, माइक, Wi-Fi, USB और 15-मिनट तापमान जांच।\n\n📌 सत्र 4 — वर्क रिपोर्ट, फीडबैक और इनवॉइस: बदले गए पुर्जों, सर्विस चार्ज, वारंटी और ग्राहक हस्ताक्षर के साथ स्पष्ट बिल तैयार करना।",
        bodyEn =
          "📌 Session 1 — Hardware & Software Issues: Check 19.5V adapter via DMM, inspect VRM short on no-power, clear clogged blower fins on thermal shutdown, reseat ZIF ribbon on dead keys.\n\n📌 Session 2 — Maintenance Process: Tighten loose display hinges, clear intake dust, update BIOS only on AC + charged battery.\n\n📌 Session 3 — Testing Repaired Laptops: Verify AC & battery boot, charging %, all keys, trackpad, audio/mic, webcam, Wi-Fi, USB & temperatures.\n\n📌 Session 4 — Work Report, Feedback & Invoice: Itemize spare parts, service labor, warranty terms, and collect signed customer feedback.",
        equationsGu =
          "• બેટરી હેલ્થ (%): Wear Health = (Full Charge Capacity / Design Capacity) × 100%\n• એડેપ્ટર વોલ્ટેજ ટોલરન્સ: 19.5V એડેપ્ટર → 19.0V થી 20.0V (લોડ વિના)\n• ઇન્વોઇસ કુલ રકમ: Total = Spare Parts + Service Charge + Applicable Tax",
        equationsHi =
          "• बैटरी स्वास्थ्य (%): Health = (Full Charge Capacity / Design Capacity) × 100%\n• एडॉप्टर जांच: 19.5V एडॉप्टर → 19.0V–20.0V DC\n• इनवॉइस कुल राशि: Total = पार्ट्स मूल्य + सर्विस चार्ज + टैक्स",
        equationsEn =
          "• Battery Health % = (Full Charge Capacity / Design Capacity) × 100%\n• Adapter No-Load Check: 19.5V rated → 19.0V–20.0V DC on DMM\n• Service Invoice: Total = Parts Cost + Labor Charge + Applicable Tax",
        impQuestionsGu =
          "Q: જો લેપટોપમાં 'Plugged in, not charging' બતાવે તો કયા 3 પગલાં તપાસશો?\nA: (1) એડેપ્ટર 19.5V અને સેન્ટર ID પિન તપાસવી, (2) બેટરી વેર/હેલ્થ રિપોર્ટ (`powercfg /batteryreport`), (3) AC ઓવર-કરંટ/બેટરી ડ્રાઇવર રીસેટ.\n---\nQ: રિપેર થયેલ લેપટોપ ગ્રાહકને સોંપતા પહેલાં કયા પોસ્ટ-રિપેર ટેસ્ટ કરવા જોઈએ?\nA: બેટરી ચાર્જિંગ, બધી કી, ટચપેડ, Wi-Fi, USB પોર્ટ, વેબકેમ, સ્પીકર અને CPU તાપમાન.\n---\nQ: લેપટોપ BIOS અપડેટ કરતી વખતે કઈ સાવચેતી જરૂરી છે?\nA: બેટરી ઓછામાં ઓછી 50% ચાર્જ હોવી જોઈએ અને AC એડેપ્ટર જોડાયેલું હોવું જોઈએ; પાવર બંધ થાય તો મધરબોર્ડ બ્રિક થઈ શકે છે.",
        impQuestionsHi =
          "Q: यदि लैपटॉप 'Plugged in, not charging' दिखाए तो क्या जांचेंगे?\nA: (1) 19.5V एडॉप्टर वोल्टेज व सेंटर पिन, (2) बैटरी हेल्थ रिपोर्ट, (3) चार्जर IC/बैटरी कनेक्टर।\n---\nQ: ग्राहक को लैपटॉप वापस देने से पहले टेस्टिंग चेकलिस्ट में क्या शामिल होता है?\nA: चार्जिंग, कीबोर्ड, टचपैड, Wi-Fi, ऑडियो/माइक, वेबकैम, सभी USB पोर्ट और तापमान।\n---\nQ: इनवॉइस (Invoice) में कौन-सी जानकारियाँ अनिवार्य हैं?\nA: दिनांक, ग्राहक नाम, लैपटॉप मॉडल/सीरियल नंबर, बदले गए पुर्जों का विवरण, वारंटी व कुल राशि।",
        impQuestionsEn =
          "Q: What causes a laptop to show 'Plugged in, not charging'?\nA: Damaged adapter center Sense/ID pin, degraded Li-Ion battery pack (<40% health), or faulty charger IC.\n---\nQ: What safety rule applies before flashing a laptop BIOS update?\nA: Keep BOTH the AC adapter plugged in AND battery >50% charged so power loss cannot corrupt BIOS.\n---\nQ: What must a Post-Repair Invoice and Work Report include?\nA: Device serial/model, fault found, parts replaced, warranty period, itemized bill, and customer signature.",
        rememberTipGu = "કસ્ટમરના લેપટોપ પર BIOS અપડેટ કે OS રિસેટ કરતા પહેલાં હંમેશા ડેટા બેકઅપની લેખિત મંજૂરી લો!",
        rememberTipHi = "रिपेयरिंग के बाद ग्राहक के सामने सभी पोर्ट (USB, Audio, Wi-Fi, Charging) चेक करवाकर फीडबैक लें।",
        rememberTipEn = "Run the 7-point post-repair check (Power, Charge, Keys, Audio, Cam, Wi-Fi, Temp) before sealing the invoice!",
        glossaryGu = "ID પિન: એડેપ્ટર સેન્સ પિન • Wear Level: બેટરી ઘસારો • Invoice: સર્વિસ બિલ",
        glossaryHi = "ID पिन: एडॉप्टर पहचान पिन • थर्मल पेस्ट • इनवॉइस व वारंटी रिकॉर्ड",
        glossaryEn = "Adapter Sense Pin • Battery Wear Level • Burn-In Stress Test • Service Invoice",
        circuitDiagramId = "circuit_laptop_power",
        linkedPracticalId = "prac_12_3",
        estimatedMinutes = 16,
        downloadSizeKb = 730,
        isDownloadedOffline = true,
        sortOrder = 13,
      ),

      LessonEntity(
        lessonId = "lesson_12_4",
        classStd = 12,
        chapterCode = "Std 12 • Module 4 (Sessions 1–2)",
        tradeNameGu = TRADE_11_12_GU,
        tradeNameHi = TRADE_11_12_HI,
        tradeNameEn = TRADE_11_12_EN,
        unitTitleGu = "વ્યાવસાયિક આરોગ્ય, સુરક્ષા અને ગ્રીન પ્રેક્ટિસ",
        unitTitleHi = "व्यावसायिक स्वास्थ्य, सुरक्षा एवं हरित कार्यप्रणाली",
        unitTitleEn = "Occupational Health and Safety Standards",
        titleGu = "મોડ્યુલ 4: IT લેબ એર્ગોનોમિક્સ, ESD/Li-Ion સુરક્ષા અને ગ્રીન IT પ્રેક્ટિસ",
        titleHi = "मॉड्यूल 4: IT वर्कप्लेस एर्गोनॉमिक्स, ESD/बैटरी सुरक्षा और ग्रीन प्रैक्टिस",
        titleEn = "Module 4: Workplace Health, Safety & Green IT Practices",
        summaryGu = "વર્કસ્ટેશન એર્ગોનોમિક્સ, ફૂલેલી Li-Ion બેટરી અને CRT/LCD જોખમ, ESD સલામતી અને સંસ્થાકીય ગ્રીન IT.",
        summaryHi = "कार्यस्थल एर्गोनॉमिक्स, फूली Li-Ion बैटरी सुरक्षा, ESD नियम और हरित IT प्रथाएं।",
        summaryEn = "Ergonomics, Li-Ion battery hazard handling, ESD safety, energy conservation, and certified e-waste IT disposal.",
        learningOutcomesGu =
          "• ટેકનિશિયન માટે યોગ્ય બેઠક, પ્રકાશ અને એર્ગોનોમિક્સ અપનાવવું.\n• ફૂલેલી લિથિયમ-આયન બેટરી અને SMPS જોખમો સુરક્ષિત રીતે સંભાળવા.\n• ઓફિસ/સર્વિસ સેન્ટરમાં વીજ બચત અને રિફર્બિશ્ડ/E-વેસ્ટ ગ્રીન પ્રેક્ટિસ લાગુ કરવી.",
        learningOutcomesHi =
          "• कंप्यूटर कार्यस्थल पर सही एर्गोनॉमिक्स (मुद्रा, रोशनी, ब्रेक) का पालन करना।\n• फूली Li-Ion बैटरी और हाई-वोल्टेज सुरक्षा नियमों को अपनाना।\n• ऊर्जा संरक्षण, रीफर्बिशिंग और अधिकृत ई-कचरा प्रबंधन करना।",
        learningOutcomesEn =
          "• Apply proper workstation ergonomics (posture, eye level, 20-20-20 rule).\n• Safely handle swollen Li-Ion batteries, ESD zones, and fire hazards.\n• Implement Green IT practices: sleep power profiles, refurbishing, and certified e-waste recycling.",
        bodyGu =
          "📌 સેશન 1 — વર્કપ્લેસ હેલ્થ એન્ડ સેફ્ટી: (1) એર્ગોનોમિક્સ: મોનિટર આંખના લેવલે રાખો અને દર 20 મિનિટે 20 ફૂટ દૂર 20 સેકન્ડ જુઓ (20-20-20 નિયમ). (2) ફૂલેલી Li-Ion બેટરી: ક્યારેય પંચર કે વાળશો નહીં, રેતીની ડોલ કે ફાયર-સેફ કન્ટેનરમાં મૂકો. (3) ESD મેટ અને ગ્રાઉન્ડેડ કાંડા પટ્ટો પહેરો.\n\n📌 સેશન 2 — સંસ્થામાં ગ્રીન પ્રેક્ટિસ: જૂના PC ને RAM/SSD અપગ્રેડથી રિફર્બિશ કરો (E-વેસ્ટ ઘટે), મોનિટર સ્લીપ ટાઇમર ચાલુ રાખો, ડિજિટલ બિલ/ઇન્વોઇસ વાપરો (પેપર બચાવ), અને ખરાબ બેટરી/PCB ને R2/CPCB પ્રમાણિત રિસાયક્લરને આપો.",
        bodyHi =
          "📌 सत्र 1 — कार्यस्थल स्वास्थ्य व सुरक्षा: (1) एर्गोनॉमिक्स: स्क्रीन आंखों के स्तर पर रखें व 20-20-20 नेत्र नियम अपनाएं। (2) फूली Li-Ion बैटरी को कभी मोड़ें या छेदें नहीं; रेत भरे सुरक्षित पात्र में रखें। (3) ESD मैट व रिस्ट स्ट्रैप अनिवार्य है।\n\n📌 सत्र 2 — हरित अभ्यास: पुराने कंप्यूटर में SSD लगाकर रीफर्बिश करें, पावर-सेविंग स्लीप मोड सेट करें, डिजिटल इनवॉइस अपनाएं और ई-कचरा अधिकृत रीसाइक्लर को दें।",
        bodyEn =
          "📌 Session 1 — Workplace Health & Safety: (1) Ergonomics: Keep monitor top at eye level and follow the 20-20-20 eye rule. (2) Swollen Li-Ion Packs: Never puncture or heat—store in sand-filled fireproof bin. (3) Wear grounded 1MΩ-resistor ESD wrist strap.\n\n📌 Session 2 — Green Practices in Organisation: Extend PC lifespan via SSD/RAM refurbishing, configure OS sleep/power-saving modes, issue paperless digital invoices, and send retired hardware to certified e-waste recyclers.",
        equationsGu =
          "• 20-20-20 આંખ સુરક્ષા નિયમ: દર 20 મિનિટ → 20 ફૂટ દૂર → 20 સેકન્ડ\n• ESD સ્ટ્રેપ આંતરિક સુરક્ષા અવરોધ: R_esd = 1 MΩ (મેગા-ઓહ્મ)\n• રિફર્બિશ ગ્રીન અસર: 1 SSD અપગ્રેડ = જૂના લેપટોપનું આયુષ્ય +3 થી 5 વર્ષ",
        equationsHi =
          "• 20-20-20 नेत्र नियम: हर 20 मिनट → 20 फीट दूर → 20 सेकंड देखें\n• ESD स्ट्रैप सुरक्षा रेजिस्टर: R_esd = 1 MΩ\n• ग्रीन IT नियम: Reduce → Refurbish/Reuse → Certified Recycle",
        equationsEn =
          "• 20-20-20 Eye Rule: Every 20 min → look 20 ft away → for 20 sec\n• ESD Strap Safety Resistor: R_esd = 1 MΩ (limits fault current safely)\n• Green IT Hierarchy: Power Save → Refurbish (SSD/RAM) → Certified E-Waste Recycling",
        impQuestionsGu =
          "Q: ફૂલેલી લિથિયમ-આયન લેપટોપ બેટરી કાઢ્યા પછી તેનું શું કરવું જોઈએ?\nA: તેને દબાવવી કે પંચર કરવી નહીં — તરત ફાયર-સેફ રેતીવાળા કન્ટેનરમાં મૂકીને પ્રમાણિત E-વેસ્ટ રિસાયક્લરને આપવી.\n---\nQ: ESD કાંડા પટ્ટામાં 1 MΩ અવરોધ કેમ લગાવવામાં આવે છે?\nA: સ્ટેટિક ચાર્જને ધીમેથી ગ્રાઉન્ડ કરવા અને જો ટેકનિશિયન ભૂલથી લાઇવ વોલ્ટેજ અડે તો શોકથી બચાવવા માટે.\n---\nQ: સર્વિસ સેન્ટરમાં 'ગ્રીન પ્રેક્ટિસ' ના 3 ઉદાહરણ આપો.\nA: (1) જૂના PC નું SSD વડે રિફર્બિશિંગ, (2) ડિજિટલ/પેપરલેસ વર્ક રિપોર્ટ, (3) E-વેસ્ટ અલગીકરણ.",
        impQuestionsHi =
          "Q: ESD रिस्ट स्ट्रैप के अंदर 1 MΩ रेजिस्टर क्यों लगाया जाता है?\nA: यह स्टैटिक आवेश को सुरक्षित रूप से ग्राउंड करता है और गलती से करंट लगने पर तकनीशियन की रक्षा करता है।\n---\nQ: फूली हुई लैपटॉप बैटरी क्यों खतरनाक होती है?\nA: इसमें थर्मल रनअवे (आग व जहरीली गैस) का खतरा रहता है; इसे कभी पंचर न करें।\n---\nQ: IT संगठन में ग्रीन प्रैक्टिस के उदाहरण दें।\nA: पावर-सेविंग मोड, पुराने PC का रीफर्बिशिंग, और अधिकृत ई-कचरा निस्तारण।",
        impQuestionsEn =
          "Q: Why does a safe ESD wrist strap contain a built-in 1 MΩ resistor?\nA: It bleeds static charges safely to ground while limiting current if the technician accidentally touches live AC.\n---\nQ: How should a swollen Li-Ion laptop battery be handled?\nA: Discharge below 25% if safe, remove gently with plastic tools, place in a non-conductive sand container, and send to certified recycler.\n---\nQ: Name 3 Green Practices for a computer service center.\nA: Refurbishing old systems with SSDs, paperless digital invoicing, and certified e-waste segregation.",
        rememberTipGu = "ફૂલેલી Li-Ion બેટરીમાં લાગેલી આગ પાણીથી બુઝાતી નથી — તેના માટે Class D / રેતી કે CO₂ અને ખુલ્લી હવા જરૂરી છે.",
        rememberTipHi = "फूली हुई बैटरी के पास कभी हीट गन या सोल्डरिंग आयरन का उपयोग न करें!",
        rememberTipEn = "Remember the 1 MΩ ESD strap rule and never use sharp metal pry tools near a Li-Ion pouch battery!",
        glossaryGu = "એર્ગોનોમિક્સ: સુરક્ષિત શારીરિક મુદ્રા • થર્મલ રનઅવે: બેટરી આગ • રિફર્બિશિંગ: નવજીવન",
        glossaryHi = "एर्गोनॉमिक्स: सही कार्य मुद्रा • ESD: स्थैतिक विद्युत सुरक्षा • रीफर्बिशिंग",
        glossaryEn = "Ergonomics • 1MΩ ESD Protection • Thermal Runaway • Green Refurbishing",
        circuitDiagramId = null,
        linkedPracticalId = "prac_12_4",
        estimatedMinutes = 12,
        downloadSizeKb = 540,
        isDownloadedOffline = true,
        sortOrder = 14,
      ),
    )

  val practicals: List<PracticalEntity> =
    listOf(
      PracticalEntity(
        practicalId = "prac_11_1",
        classStd = 11,
        practicalCode = "PRAC-11.1 (Mod 1)",
        linkedLessonId = "lesson_11_1",
        circuitDiagramId = "circuit_computer_block",
        titleGu = "પ્રયોગ 11.1: કમ્પ્યુટર સિસ્ટમ બ્લોક્સ, પોર્ટ્સ મેપિંગ અને સ્ટોરેજ ઓળખ",
        titleHi = "प्रयोग 11.1: कंप्यूटर सिस्टम ब्लॉक, पोर्ट मैपिंग और स्टोरेज पहचान",
        titleEn = "Practical 11.1: PC Hardware Blocks, Port Mapping & Storage Check",
        aimGu = "મધરબોર્ડ પર CPU, RAM, CMOS, SSD/HDD અને પાછળના I/O પોર્ટ્સ (USB, HDMI, RJ45) ઓળખી મેપ કરવા.",
        aimHi = "मदरबोर्ड पर CPU, RAM, CMOS, SSD/HDD और I/O पोर्ट (USB, HDMI, RJ45) की पहचान व मैपिंग करना।",
        aimEn = "Identify PC system blocks, map rear I/O ports (USB 3.0, HDMI, RJ45, Audio), and compare HDD vs SSD.",
        toolsGu = "ડેસ્કટોપ કેબિનેટ/મધરબોર્ડ, SATA HDD, M.2 NVMe SSD, RAM સ્ટિક, USB/HDMI કેબલ્સ, ESD પટ્ટો",
        toolsHi = "डेस्कटॉप मदरबोर्ड, SATA HDD, M.2 NVMe SSD, RAM स्टिक, USB/HDMI केबल, ESD रिस्ट स्ट्रैप",
        toolsEn = "Desktop PC / Motherboard, SATA HDD, M.2 NVMe SSD, DDR4 RAM, USB/HDMI cables, ESD Strap",
        safetyWarningGu = "કોઈપણ આંતરિક ભાગ અડતા પહેલાં AC પાવર કોર્ડ કાઢો અને ESD કાંડા પટ્ટો પહેરો.",
        safetyWarningHi = "किसी भी आंतरिक पुर्जे को छूने से पहले AC पावर कॉर्ड हटाएं और ESD रिस्ट स्ट्रैप पहनें।",
        safetyWarningEn = "Unplug AC mains and wear a grounded ESD wrist strap before handling motherboard parts.",
        theoryShortGu = "CPU (ALU+CU), RAM અને સ્ટોરેજ વચ્ચે ઝડપી ડેટા બસ દ્વારા સંચાર થાય છે.",
        theoryShortHi = "CPU (ALU+CU), RAM और स्टोरेज के बीच सिस्टम बस द्वारा डेटा संचार होता है।",
        theoryShortEn = "CPU (ALU+CU), volatile RAM, and non-volatile SSD/HDD communicate over motherboard buses.",
        badgeLabel = "PC Hardware Mapper",
        isDownloadedOffline = true,
        sortOrder = 9,
      ),
      PracticalEntity(
        practicalId = "prac_11_2",
        classStd = 11,
        practicalCode = "PRAC-11.2 (Mod 2)",
        linkedLessonId = "lesson_11_2",
        circuitDiagramId = null,
        titleGu = "પ્રયોગ 11.2: UEFI/BIOS બૂટ ઓર્ડર, પાર્ટીશન અને Linux/Windows OS તૈયારી",
        titleHi = "प्रयोग 11.2: UEFI/BIOS बूट ऑर्डर, पार्टीशन और OS इंस्टॉलेशन तैयारी",
        titleEn = "Practical 11.2: UEFI Boot Setup, Partitioning & OS Peripheral Config",
        aimGu = "UEFI/BIOS માં USB બૂટ ઓર્ડર સેટ કરવો, GPT પાર્ટીશન પ્લાન ચકાસવો અને OS ડ્રાઇવર/પ્રિન્ટર તપાસવું.",
        aimHi = "UEFI/BIOS में USB बूट ऑर्डर सेट करना, GPT पार्टीशन जांचना और ड्राइवर/प्रिंटर कन्फिगर करना।",
        aimEn = "Configure UEFI boot order, verify GPT/ext4/NTFS partition layout, and check peripheral drivers.",
        toolsGu = "ડેસ્કટોપ/લેપટોપ PC, 16GB બૂટેબલ USB ડ્રાઇવ, USB પ્રિન્ટર, નેટવર્ક LAN કેબલ",
        toolsHi = "डेस्कटॉप/लैपटॉप PC, 16GB बूटेबल USB ड्राइव, USB प्रिंटर, LAN केबल",
        toolsEn = "Desktop/Laptop PC, 16GB Bootable USB Flash Drive, USB Printer, Ethernet Cable",
        safetyWarningGu = "ખોટી ડ્રાઇવ ફોર્મેટ ન થાય તે માટે ઇન્સ્ટોલેશન પહેલાં હંમેશા ડેટા બેકઅપ અને પાર્ટીશન લેબલ તપાસો.",
        safetyWarningHi = "गलत ड्राइव फॉर्मेट होने से बचाने के लिए पहले डेटा बैकअप और पार्टीशन आकार (GB) जांचें।",
        safetyWarningEn = "Verify drive size and back up customer data before creating or formatting GPT partitions.",
        theoryShortGu = "UEFI સાથે GPT સ્કીમ તથા Linux માટે `/` (ext4) + `swap` પાર્ટીશન વપરાય છે.",
        theoryShortHi = "UEFI के साथ GPT स्कीम तथा Linux में `/` (ext4) और `swap` पार्टीशन आवश्यक हैं।",
        theoryShortEn = "UEFI boots GPT disks; Linux requires `/` (ext4) + swap, followed by `lsusb` & CUPS printer setup.",
        badgeLabel = "OS Configurator",
        isDownloadedOffline = true,
        sortOrder = 10,
      ),
      PracticalEntity(
        practicalId = "prac_11_3",
        classStd = 11,
        practicalCode = "PRAC-11.3 (Mod 3)",
        linkedLessonId = "lesson_11_3",
        circuitDiagramId = "circuit_computer_block",
        titleGu = "પ્રયોગ 11.3: ATX 24-પિન SMPS પેપરક્લિપ ટેસ્ટ અને DC રેલ્સ (+12V/+5V/+3.3V) માપન",
        titleHi = "प्रयोग 11.3: ATX 24-पिन SMPS पेपरक्लिप टेस्ट और DC रेल वोल्टेज मापन",
        titleEn = "Practical 11.3: ATX SMPS Paperclip Test & DC Rail Measurement",
        aimGu = "SMPS ને મધરબોર્ડથી અલગ કરી DMM વડે +12V, +5V, +3.3V અને Power-Good (+5V) રેલ્સ માપવા.",
        aimHi = "SMPS को मदरबोर्ड से अलग कर DMM द्वारा +12V, +5V, +3.3V और Power-Good वोल्टेज मापना।",
        aimEn = "Jump PS_ON# to GND safely outside the motherboard and measure +12V, +5V, +3.3V & PG rails via DMM.",
        toolsGu = "ATX SMPS યુનિટ, ઇન્સ્યુલેટેડ જમ્પર/પેપરક્લિપ, ડિજિટલ મલ્ટિમીટર (20V DC મોડ)",
        toolsHi = "ATX SMPS यूनिट, इंसुलेटेड जम्पर/पेपरक्लिप, डिजिटल मल्टीमीटर (20V DC रेंज)",
        toolsEn = "ATX SMPS Unit, Insulated Jumper Wire, Digital Multimeter (20V DC range)",
        safetyWarningGu = "SMPS કેસ ક્યારેય ખોલશો નહીં (અંદર 320V+ DC હોય છે); બધા મધરબોર્ડ/HDD કેબલ્સ કાઢીને જ ટેસ્ટ કરો.",
        safetyWarningHi = "SMPS का मेटल केस कभी न खोलें; सभी मदरबोर्ड व ड्राइव केबल हटाकर ही 24-पिन टेस्ट करें।",
        safetyWarningEn = "NEVER open SMPS metal casing! Disconnect all PC loads before jumpering Green to Black.",
        theoryShortGu = "માનક ±5% મર્યાદા: +12V (11.4–12.6V), +5V (4.75–5.25V), +3.3V (3.14–3.47V).",
        theoryShortHi = "मानक ±5% सीमा: +12V (11.4–12.6V), +5V (4.75–5.25V), +3.3V (3.14–3.47V)।",
        theoryShortEn = "All rails must fall within ±5%: +12V (11.4–12.6V), +5V (4.75–5.25V), +3.3V (3.14–3.47V).",
        badgeLabel = "SMPS Power Tech",
        isDownloadedOffline = true,
        sortOrder = 11,
      ),
      PracticalEntity(
        practicalId = "prac_11_4",
        classStd = 11,
        practicalCode = "PRAC-11.4 (Mod 4)",
        linkedLessonId = "lesson_11_4",
        circuitDiagramId = "circuit_computer_block",
        titleGu = "પ્રયોગ 11.4: ડેસ્કટોપ કમ્પ્યુટર એસેમ્બલી — CPU, થર્મલ પેસ્ટ, RAM અને ફ્રન્ટ પેનલ",
        titleHi = "प्रयोग 11.4: डेस्कटॉप कंप्यूटर असेंबली — CPU, थर्मल पेस्ट, RAM और फ्रंट पैनल",
        titleEn = "Practical 11.4: Complete Desktop PC Assembly & POST Verification",
        aimGu = "બ્રાસ સ્ટેન્ડઓફ્સ, CPU, થર્મલ પેસ્ટ, RAM, SSD, SMPS અને F_PANEL જોડીને PC POST બૂટ કરવો.",
        aimHi = "स्टैंडऑफ, CPU, थर्मल पेस्ट, RAM, SSD, SMPS और फ्रंट पैनल जोड़कर PC को POST बूट करना।",
        aimEn = "Install motherboard, CPU, cooler, RAM, SSD, SMPS & front headers, then verify clean POST screen.",
        toolsGu = "ATX કેબિનેટ, મધરબોર્ડ, CPU, થર્મલ પેસ્ટ, કૂલર, RAM, SSD, SMPS, મેગ્નેટિક સ્ક્રુડ્રાઇવર, ESD પટ્ટો",
        toolsHi = "ATX कैबिनेट, मदरबोर्ड, CPU, थर्मल पेस्ट, कूलर, RAM, SSD, SMPS, स्क्रूड्राइवर, ESD स्ट्रैप",
        toolsEn = "ATX Cabinet, Motherboard, CPU, Thermal Paste, Cooler, RAM, SSD, SMPS, Magnetic Screwdriver, ESD Strap",
        safetyWarningGu = "ESD કાંડા પટ્ટો પહેરો; CPU સોકેટ પિન્સને હાથ ન લગાડો; વધારાના સ્ટેન્ડઓફ્સ કાઢી નાખો.",
        safetyWarningHi = "ESD रिस्ट स्ट्रैप पहनें; CPU पिन को न छुएं; अतिरिक्त स्टैंडऑफ हटाएं।",
        safetyWarningEn = "Wear ESD strap, avoid touching CPU socket pins, and verify standoff alignment.",
        theoryShortGu = "યોગ્ય 24-પિન + 8-પિન CPU પાવર અને RAM સીટિંગથી 1 ટૂંકી બીપ સાથે POST પાસ થાય છે.",
        theoryShortHi = "सही 24-पिन + 8-पिन पावर और RAM फिटिंग से 1 छोटी बीप के साथ POST सफल होता है।",
        theoryShortEn = "Proper 24-pin + 8-pin EPS power and latched RAM produce a clean single-beep POST.",
        badgeLabel = "PC System Builder",
        isDownloadedOffline = true,
        sortOrder = 12,
      ),

      // ==================== GRADE XII PRACTICALS ====================
      PracticalEntity(
        practicalId = "prac_12_1",
        classStd = 12,
        practicalCode = "PRAC-12.1 (Mod 1)",
        linkedLessonId = "lesson_12_1",
        circuitDiagramId = "circuit_computer_block",
        titleGu = "પ્રયોગ 12.1: ડેસ્કટોપ નો-ડિસ્પ્લે નિદાન, RAM/CMOS સફાઈ અને વર્ક રિપોર્ટ",
        titleHi = "प्रयोग 12.1: डेस्कटॉप नो-डिस्प्ले दोष निदान, RAM/CMOS सफाई और वर्क रिपोर्ट",
        titleEn = "Practical 12.1: Desktop No-Display Troubleshooting & Preventive Care",
        aimGu = "નો-ડિસ્પ્લે ડેસ્કટોપમાં CMOS બેટરી (3V) તપાસવી, RAM પિન્સ IPA થી સાફ કરવી અને નિવારક સફાઈ કરવી.",
        aimHi = "नो-डिस्प्ले डेस्कटॉप में CMOS बैटरी (3V) जांचना, RAM पिन IPA से साफ करना और प्रिवेंटिव मेंटेनेंस करना।",
        aimEn = "Troubleshoot a No-Display desktop: test CMOS 3V cell, clean RAM contacts with IPA, blow dust & log report.",
        toolsGu = "ડેસ્કટોપ PC, 99% IPA, લિન્ટ-ફ્રી સ્વેબ, DMM, એર બ્લોઅર, ESD પટ્ટો, વર્ક રિપોર્ટ ફોર્મ",
        toolsHi = "डेस्कटॉप PC, 99% IPA, लिंट-फ्री कपड़ा, DMM, एयर ब्लोअर, ESD स्ट्रैप, वर्क रिपोर्ट फॉर्म",
        toolsEn = "Desktop PC, 99% Isopropyl Alcohol (IPA), Lint-Free Swabs, DMM, Air Blower, ESD Strap, Work Report",
        safetyWarningGu = "પાવર કેબલ કાઢીને 10 સેકન્ડ પાવર બટન દબાવી કેપેસિટર ડિસ્ચાર્જ કરો; ફક્ત 99% IPA વાપરો.",
        safetyWarningHi = "पावर केबल निकालकर 10 सेकंड पावर बटन दबाएं (डिस्चार्ज); सफाई के लिए केवल 99% IPA उपयोग करें।",
        safetyWarningEn = "Unplug AC and hold power button 10s to drain standby caps; clean contacts only with 99% IPA.",
        theoryShortGu = "ઓક્સિડાઇઝ્ડ RAM પિન્સ અને નબળી CMOS બેટરી (<2.7V) નો-ડિસ્પ્લેના સૌથી સામાન્ય કારણો છે.",
        theoryShortHi = "ऑक्सीडाइज्ड RAM कॉन्टैक्ट और कमजोर CMOS बैटरी (<2.7V) नो-डिस्प्ले के प्रमुख कारण हैं।",
        theoryShortEn = "Oxidized RAM pins and depleted CR2032 (<2.7V) are the top two causes of No-Display faults.",
        badgeLabel = "Desktop Diagnostician",
        isDownloadedOffline = true,
        sortOrder = 13,
      ),
      PracticalEntity(
        practicalId = "prac_12_2",
        classStd = 12,
        practicalCode = "PRAC-12.2 (Mod 2)",
        linkedLessonId = "lesson_12_2",
        circuitDiagramId = "circuit_laptop_power",
        titleGu = "પ્રયોગ 12.2: લેપટોપ ડિસએસેમ્બલી, બેટરી આઇસોલેશન, SODIMM RAM અને થર્મલ રિપેસ્ટ",
        titleHi = "प्रयोग 12.2: लैपटॉप डिसअसेंबली, बैटरी आइसोलेशन, SODIMM RAM और थर्मल पेस्ट",
        titleEn = "Practical 12.2: Laptop Disassembly, SODIMM Upgrade & Thermal Repaste",
        aimGu = "લેપટોપ સુરક્ષિત રીતે ખોલી બેટરી અલગ કરવી, SODIMM RAM 30° ખૂણે ઇન્સ્ટોલ કરવી અને હીટ-પાઇપ પેસ્ટ બદલવી.",
        aimHi = "लैपटॉप सुरक्षित खोलकर बैटरी हटाना, 30° कोण पर SODIMM RAM लगाना और थर्मल पेस्ट बदलना।",
        aimEn = "Open laptop base, disconnect battery FIRST, upgrade SODIMM RAM at 30°, and repaste copper heat-pipe.",
        toolsGu = "લેપટોપ યુનિટ, પ્રિસિઝન સ્ક્રુડ્રાઇવર (PH0/PH00), પ્લાસ્ટિક સ્પજર, SODIMM RAM, થર્મલ પેસ્ટ, IPA, ESD પટ્ટો",
        toolsHi = "लैपटॉप, प्रिसीजन स्क्रूड्राइवर, प्लास्टिक स्पजर, SODIMM RAM, थर्मल पेस्ट, 99% IPA, ESD स्ट्रैप",
        toolsEn = "Laptop Unit, Precision Screwdriver (PH0/PH00), Plastic Spudger, SODIMM RAM, Thermal Paste, 99% IPA, ESD Strap",
        safetyWarningGu = "બેઝ કવર ખૂલતા જ સૌપ્રથમ BAT કનેક્ટર અલગ કરો; મેટલ સ્ક્રુડ્રાઇવરથી બેટરી કે ZIF કેબલ ન ઉઠાવો.",
        safetyWarningHi = "कवर खुलते ही सबसे पहले बैटरी कनेक्टर (BAT) हटाएं; प्लास्टिक स्पजर से ही रिबन केबल खोलें।",
        safetyWarningEn = "Disconnect internal Li-Ion battery FIRST! Use only plastic pry tools on ZIF latches and battery.",
        theoryShortGu = "ક્રમવાર (4-3-2-1) હીટ-સિંક ખોલી જૂની સૂકી પેસ્ટ IPA થી સાફ કરવાથી તાપમાન 10–15°C ઘટે છે.",
        theoryShortHi = "हीट-सिंक स्क्रू क्रम से खोलकर नया थर्मल पेस्ट लगाने से CPU तापमान 10–15°C कम होता है।",
        theoryShortEn = "Cleaning dried paste and applying fresh paste lowers load temperature by 10–15°C.",
        badgeLabel = "Laptop Hardware Pro",
        isDownloadedOffline = true,
        sortOrder = 14,
      ),
      PracticalEntity(
        practicalId = "prac_12_3",
        classStd = 12,
        practicalCode = "PRAC-12.3 (Mod 3)",
        linkedLessonId = "lesson_12_3",
        circuitDiagramId = "circuit_laptop_power",
        titleGu = "પ્રયોગ 12.3: રિપેર થયેલ લેપટોપનું પોસ્ટ-રિપેર ટેસ્ટિંગ, 19.5V ચેક અને ઇન્વોઇસ",
        titleHi = "प्रयोग 12.3: रिपेयर किए गए लैपटॉप की टेस्टिंग, 19.5V जांच और वर्क रिपोर्ट/बिल",
        titleEn = "Practical 12.3: Laptop Stress Testing, 19.5V Rail Check & Service Invoice",
        aimGu = "એડેપ્ટર 19.5V માપીને બધી કી, ટચપેડ, Wi-Fi, USB, ઓડિયો, બેટરી ચાર્જિંગ ચકાસવી અને ઇન્વોઇસ તૈયાર કરવું.",
        aimHi = "एडॉप्टर 19.5V मापकर कीबोर्ड, टचपैड, Wi-Fi, USB, ऑडियो, चार्जिंग जांचना व ग्राहक इनवॉइस बनाना।",
        aimEn = "Verify 19.5V adapter output, run 7-point laptop post-repair functional test, and draft itemized invoice.",
        toolsGu = "રિપેર્ડ લેપટોપ, 19.5V એડેપ્ટર, DMM, USB પેનડ્રાઇવ, હેડફોન, સર્વિસ વર્ક રિપોર્ટ/ઇન્વોઇસ ટેમ્પ્લેટ",
        toolsHi = "रिपेयर्ड लैपटॉप, 19.5V एडॉप्टर, DMM, USB ड्राइव, हेडफोन, वर्क रिपोर्ट/इनवॉइस फॉर्म",
        toolsEn = "Repaired Laptop, 19.5V Power Adapter, DMM, USB Flash Drive, Headphones, Service Report & Invoice Form",
        safetyWarningGu = "એડેપ્ટર પિન માપતી વખતે DMM પ્રોબ્સને અંદર-બહાર શોર્ટ ન કરો; CPU તાપમાન 85°C થી ઉપર ન જાય તે જુઓ.",
        safetyWarningHi = "एडॉप्टर पिन जांचते समय प्रोब शॉर्ट न करें; टेस्टिंग में हवा के वेंट खुले रखें।",
        safetyWarningEn = "Avoid shorting adapter barrel pin during DMM check; keep exhaust vents unobstructed on stress test.",
        theoryShortGu = "7-પોઇન્ટ ફંક્શનલ ટેસ્ટ (Power, Charge, Keys, Touchpad, Audio, Wi-Fi, Temp) રિટર્ન કમ્પ્લેઇન્ટ ઝીરો રાખે છે.",
        theoryShortHi = "7-पॉइंट पोस्ट-रिपेयर चेकलिस्ट से ग्राहक शिकायतें शून्य रहती हैं।",
        theoryShortEn = "A 7-point post-repair inspection ensures zero repeat complaints and builds customer trust.",
        badgeLabel = "Service Engineer",
        isDownloadedOffline = true,
        sortOrder = 15,
      ),
      PracticalEntity(
        practicalId = "prac_12_4",
        classStd = 12,
        practicalCode = "PRAC-12.4 (Mod 4)",
        linkedLessonId = "lesson_12_4",
        circuitDiagramId = null,
        titleGu = "પ્રયોગ 12.4: ESD સ્ટ્રેપ 1MΩ વેરિફિકેશન, એર્ગોનોમિક્સ ઓડિટ અને E-વેસ્ટ નિકાલ",
        titleHi = "प्रयोग 12.4: ESD स्ट्रैप 1MΩ जांच, एर्गोनॉमिक्स ऑडिट और हरित ई-कचरा निपटान",
        titleEn = "Practical 12.4: ESD 1MΩ Strap Check, Ergonomics & Green IT Audit",
        aimGu = "મલ્ટિમીટરથી ESD પટ્ટાનો 1MΩ સુરક્ષા અવરોધ માપવો, લેબ એર્ગોનોમિક્સ તપાસવું અને Li-Ion/E-વેસ્ટ અલગ કરવું.",
        aimHi = "मल्टीमीटर से ESD स्ट्रैप का 1MΩ सुरक्षा रेजिस्टेंस मापना, एर्गोनॉमिक्स और ई-कचरा ऑडिट करना।",
        aimEn = "Verify 1MΩ safety resistor in ESD strap via DMM, audit workstation posture, and sort Li-Ion e-waste.",
        toolsGu = "ESD કાંડા પટ્ટો અને મેટ, DMM (2MΩ રેન્જ), ફૂલેલી/ખરાબ ડમી બેટરી સેલ, E-વેસ્ટ લેબલ બિન",
        toolsHi = "ESD रिस्ट स्ट्रैप व मैट, DMM (2MΩ रेंज), डमी बैटरी पैक, ई-कचरा बिन",
        toolsEn = "ESD Wrist Strap & Mat, DMM (2MΩ range), Dummy Swollen Battery Sample, Labeled E-Waste Bins",
        safetyWarningGu = "જો ESD પટ્ટામાં 1 MΩ થી ઓછો (0Ω શોર્ટ) કે અનંત (OL) અવરોધ આવે તો તે પટ્ટો બદલી નાખો.",
        safetyWarningHi = "यदि ESD स्ट्रैप 0Ω या OL दिखाए तो उसका उपयोग न करें — नया सुरक्षित स्ट्रैप पहनें।",
        safetyWarningEn = "Discard any ESD strap reading <800 kΩ (shock hazard) or OL (broken ground wire).",
        theoryShortGu = "1 MΩ શ્રેણી અવરોધ ESD ને દૂર કરે છે અને 230V અકસ્માતમાં કરંટને <0.25 mA રાખે છે.",
        theoryShortHi = "1 MΩ रेजिस्टर स्टैटिक चार्ज को धीरे-धीरे हटाता है और करंट से सुरक्षा देता है।",
        theoryShortEn = "A 1 MΩ series resistor safely drains static while limiting accidental AC touch current.",
        badgeLabel = "Green IT Auditor",
        isDownloadedOffline = true,
        sortOrder = 16,
      ),
    )

  val practicalSteps: List<PracticalStepEntity> =
    listOf(
      // Prac 11.1
      PracticalStepEntity("s_11_1_1", "prac_11_1", 1, true, "સુરક્ષા: PC નો પાવર કોર્ડ બહાર કાઢો અને ESD કાંડા પટ્ટો ગ્રાઉન્ડ સાથે જોડો.", "सुरक्षा: AC पावर कॉर्ड हटाएं और ESD रिस्ट स्ट्रैप ग्राउंड से जोड़ें।", "Safety Check: Unplug AC mains and attach grounded ESD wrist strap.", "AC અલગ, ESD OK", "AC अलग, ESD OK", "AC unplugged, ESD on", "SMPS"),
      PracticalStepEntity("s_11_1_2", "prac_11_1", 2, false, "મધરબોર્ડ પર CPU સોકેટ, DDR RAM સ્લોટ, CMOS 3V બેટરી અને SATA/M.2 સ્લોટ ઓળખો.", "मदरबोर्ड पर CPU सॉकेट, RAM स्लॉट, CMOS 3V बैटरी और SATA/M.2 स्लॉट पहचानें।", "Locate CPU socket, DIMM RAM slots, CR2032 CMOS battery, and SATA/M.2 ports.", "બધા બ્લોક્સ મેપ થયા", "सभी ब्लॉक चिह्नित", "Blocks mapped", "CPU"),
      PracticalStepEntity("s_11_1_3", "prac_11_1", 3, false, "પાછળના I/O પેનલ પર USB 2.0/3.0, HDMI/VGA, RJ45 LAN અને ઓડિયો જેક નોંધો.", "रियर I/O पैनल पर USB, HDMI/VGA, RJ45 ईथरनेट और ऑडियो जैक की सूची बनाएं।", "Map rear I/O ports (USB 3.0 blue, HDMI, RJ45 Ethernet, Audio) and compare HDD vs SSD speeds.", "I/O પોર્ટ્સ ચકાસ્યા", "I/O पोर्ट जांचे गए", "I/O ports verified", "SSD"),

      // Prac 11.2
      PracticalStepEntity("s_11_2_1", "prac_11_2", 1, true, "સુરક્ષા: પાર્ટીશન સ્ક્રીન પર આગળ વધતા પહેલાં ગ્રાહક ડેટા બેકઅપની ખાતરી કરો.", "सुरक्षा: पार्टीशन फॉर्मेट करने से पहले डेटा बैकअप की पुष्टि करें।", "Safety Check: Confirm customer data backup before touching drive partitions.", "બેકઅપ ચકાસેલ", "बैकअप की पुष्टि", "Backup verified", null),
      PracticalStepEntity("s_11_2_2", "prac_11_2", 2, false, "બૂટ સમયે F2/Del/F12 દબાવી UEFI મેનૂમાં બૂટેબલ USB ને પ્રથમ ક્રમે ગોઠવો.", "बूट के समय F2/Del दबाकर UEFI मेन्यू में बूटेबल USB को प्रथम प्राथमिकता दें।", "Enter UEFI setup (F2/Del), verify UEFI mode (GPT), and set bootable USB first.", "UEFI + USB બૂટ OK", "UEFI + USB बूट OK", "UEFI boot ready", null),
      PracticalStepEntity("s_11_2_3", "prac_11_2", 3, false, "Linux માં `/` (ext4) + `swap` અથવા Windows માં NTFS પાર્ટીશન તપાસી `lsusb` / Device Manager દ્વારા પ્રિન્ટર જોડો.", "Linux में `/` (ext4) + `swap` या Windows में NTFS जांचकर `lsusb` / Device Manager से प्रिंटर जोड़ें।", "Verify NTFS (Windows) or `/` + swap (Linux) layout, then check peripheral drivers (`lsusb` / CUPS).", "ડ્રાઇવર્સ અને પ્રિન્ટર OK", "ड्राइवर व प्रिंटर OK", "Drivers & printer OK", null),

      // Prac 11.3
      PracticalStepEntity("s_11_3_1", "prac_11_3", 1, true, "ઉચ્ચ સુરક્ષા: SMPS કેસ ક્યારેય ખોલશો નહીં અને 24-પિન ATX કેબલ મધરબોર્ડથી અલગ કરો.", "उच्च सुरक्षा: SMPS केस न खोलें तथा 24-पिन केबल को मदरबोर्ड व ड्राइव से अलग रखें।", "Safety Check: Never open SMPS casing; unplug 24-pin ATX & all drive leads from PC.", "SMPS અલગ થયેલ", "SMPS आइसोलेटेड", "SMPS isolated", "SMPS"),
      PracticalStepEntity("s_11_3_2", "prac_11_3", 2, false, "24-પિન કનેક્ટરમાં લીલો (PS_ON# Pin 16) અને કાળો (GND) વાયર જમ્પરથી જોડી AC ચાલુ કરો.", "24-पिन कनेक्टर में हरे (PS_ON#) और काले (GND) पिन को जम्पर से जोड़कर स्विच ऑन करें।", "Jumper Green (Pin 16 PS_ON#) to adjacent Black (GND) and switch SMPS AC rocker ON.", "SMPS ફેન ફરે છે", "SMPS फैन घूम रहा है", "SMPS fan spins", "FAN"),
      PracticalStepEntity("s_11_3_3", "prac_11_3", 3, false, "DMM (20V DC) થી કાળી પ્રોબ GND પર રાખી +12V (પીળો), +5V (લાલ), +3.3V (નારંગી) અને PG (ગ્રે) માપો.", "DMM (20V DC) से +12V (पीला), +5V (लाल), +3.3V (नारंगी) और PG (ग्रे) रेल मापें।", "Probe Yellow (+12V), Red (+5V), Orange (+3.3V), and Grey (+5V PG) against Black GND.", "બધા વોલ્ટેજ ±5% અંદર", "सभी वोल्टेज ±5% में", "All rails within ±5%", "SMPS"),

      // Prac 11.4
      PracticalStepEntity("s_11_4_1", "prac_11_4", 1, true, "સુરક્ષા: ESD પટ્ટો પહેરો અને કેબિનેટમાં મધરબોર્ડના છિદ્રો પ્રમાણે જ બ્રાસ સ્ટેન્ડઓફ્સ લગાવો.", "सुरक्षा: ESD स्ट्रैप पहनें और मदरबोर्ड छेदों के अनुसार ही ब्रास स्टैंडऑफ लगाएं।", "Safety Check: Wear ESD strap and install brass standoffs matching motherboard holes 1-to-1.", "ESD અને સ્ટેન્ડઓફ્સ OK", "ESD व स्टैंडऑफ OK", "Standoffs aligned", "CPU"),
      PracticalStepEntity("s_11_4_2", "prac_11_4", 2, false, "CPU નું સોનેરી ત્રિકોણ મેળવી સોકેટમાં મૂકો, ~4mm થર્મલ પેસ્ટ લગાવી કૂલર અને RAM (A2+B2) ફિટ કરો.", "CPU त्रिकोण मिलाकर रखें, मटर जितना थर्मल पेस्ट लगाकर कूलर और RAM (A2+B2) लगाएं।", "Align CPU Pin-1 triangle, apply pea-sized thermal paste, mount cooler, and latch RAM sticks.", "CPU અને RAM ફિટ", "CPU व RAM फिट", "CPU & RAM seated", "RAM"),
      PracticalStepEntity("s_11_4_3", "prac_11_4", 3, false, "24-પિન ATX, 8-પિન CPU પાવર, SSD અને F_PANEL (`PWR_SW`) જોડીને પાવર ચાલુ કરી POST સ્ક્રીન ચકાસો.", "24-पिन ATX, 8-पिन CPU पावर, SSD व फ्रंट पैनल जोड़कर POST स्क्रीन जांचें।", "Plug 24-pin ATX, 8-pin EPS, SATA/NVMe SSD & `PWR_SW`, power on, and confirm POST screen.", "POST પાસ (1 Beep)", "POST पास (1 Beep)", "POST pass verified", "SSD"),

      // Prac 12.1
      PracticalStepEntity("s_12_1_1", "prac_12_1", 1, true, "સુરક્ષા: AC અનપ્લગ કરી પાવર બટન 10 સેકન્ડ દબાવો (ડિસ્ચાર્જ) અને ESD પટ્ટો પહેરો.", "सुरक्षा: AC अनप्लग कर पावर बटन 10 सेकंड दबाएं (डिस्चार्ज) और ESD स्ट्रैप पहनें।", "Safety Check: Unplug AC, hold power button 10s to drain caps, and wear ESD strap.", "સિસ્ટમ ડિસ્ચાર્જ્ડ", "सिस्टम डिस्चार्ज्ड", "Discharged & ESD on", "CMOS"),
      PracticalStepEntity("s_12_1_2", "prac_12_1", 2, false, "DMM થી CR2032 CMOS બેટરી માપો (≥ 2.8V) અને RAM કાઢી ગોલ્ડ પિન્સ 99% IPA થી સાફ કરો.", "DMM से CMOS बैटरी (≥ 2.8V) जांचें और RAM की गोल्ड पिन को 99% IPA से साफ करें।", "Measure CMOS CR2032 (replace if <2.7V) and clean RAM gold fingers using 99% IPA.", "CMOS ≥2.8V, RAM સાફ", "CMOS ≥2.8V, RAM साफ", "CMOS & RAM cleaned", "RAM"),
      PracticalStepEntity("s_12_1_3", "prac_12_1", 3, false, "એર બ્લોઅરથી હીટ-સિંકની ધૂળ સાફ કરો, RAM ફરી લગાવી 15 મિનિટ સ્ટ્રેસ ટેસ્ટ અને વર્ક રિપોર્ટ ભરો.", "एयर ब्लोअर से धूल साफ करें, RAM लगाकर डिस्प्ले/तापमान जांचें और वर्क रिपोर्ट भरें।", "Blow out heatsink dust, reseat RAM, verify POST display & temp, and complete Work Report.", "ડિસ્પ્લે અને ટેસ્ટ OK", "डिस्प्ले व टेस्ट OK", "Display & report OK", "FAN"),

      // Prac 12.2
      PracticalStepEntity("s_12_2_1", "prac_12_2", 1, true, "ઉચ્ચ સુરક્ષા: બોટમ પેનલ ખોલતા જ સૌપ્રથમ આંતરિક Li-Ion બેટરી (BAT) કનેક્ટર અલગ કરો!", "उच्च सुरक्षा: बैक कवर खुलते ही सबसे पहले बैटरी कनेक्टर (BAT) मदरबोर्ड से अलग करें!", "Safety Check: Remove bottom cover and disconnect internal Li-Ion battery connector FIRST.", "BAT અલગ થયેલ", "BAT डिस्कनेक्टेड", "Battery unplugged", "BAT"),
      PracticalStepEntity("s_12_2_2", "prac_12_2", 2, false, "SODIMM RAM ને 30° ખૂણે સ્લોટમાં દાખલ કરી બંને ક્લિપ ક્લિક થાય ત્યાં સુધી નીચે દબાવો.", "SODIMM RAM को 30° कोण पर स्लॉट में डालकर दोनों क्लिप लॉक होने तक दबाएं।", "Insert SODIMM RAM at 30° angle and press flat until both side clips snap securely.", "SODIMM લોક થઈ", "SODIMM लॉक हुई", "SODIMM latched", "SODIMM"),
      PracticalStepEntity("s_12_2_3", "prac_12_2", 3, false, "હીટ-પાઇપ સ્ક્રૂ 4-3-2-1 ક્રમમાં ખોલી સૂકી પેસ્ટ IPA થી સાફ કરી નવી થર્મલ પેસ્ટ લગાવો અને બ્લોઅર જોડો.", "हीट-पाइप स्क्रू 4-3-2-1 क्रम में खोलकर सूखा पेस्ट IPA से हटाएं, नया पेस्ट लगाएं व ब्लोअर जोड़ें।", "Unscrew heatsink (4-3-2-1), clean old paste with IPA, apply fresh paste, tighten (1-2-3-4) & reconnect BAT.", "થર્મલ રિપેસ્ટ પૂર્ણ", "थर्मल रिपेस्ट पूर्ण", "Repaste complete", "BLOWER"),

      // Prac 12.3
      PracticalStepEntity("s_12_3_1", "prac_12_3", 1, true, "સુરક્ષા: 19.5V એડેપ્ટર પિન માપતી વખતે DMM પ્રોબ્સ શોર્ટ ન થાય તેનું ધ્યાન રાખો અને વેન્ટ્સ ખુલ્લા રાખો.", "सुरक्षा: 19.5V एडॉप्टर पिन जांचते समय प्रोब शॉर्ट न करें और कूलिंग वेंट खुले रखें।", "Safety Check: Avoid shorting adapter barrel pins with DMM probes; keep exhaust vents clear.", "પ્રોબ્સ સુરક્ષિત", "प्रोब सुरक्षित", "Probes safe", "ADP"),
      PracticalStepEntity("s_12_3_2", "prac_12_3", 2, false, "DMM 20V DC પર એડેપ્ટર વોલ્ટેજ (~19.5V) માપો અને 7-પોઇન્ટ ટેસ્ટ (Key, Pad, Wi-Fi, USB, Audio, Charge, Temp) ચલાવો.", "DMM से 19.5V एडॉप्टर जांचें और 7-पॉइंट टेस्ट (Key, Pad, Wi-Fi, USB, Audio, Charge, Temp) करें।", "Measure 19.5V adapter DC output and execute 7-point functional test (Charge, Keys, Pad, Wi-Fi, USB, Audio, Temp).", "7/7 ટેસ્ટ પાસ", "7/7 टेस्ट पास", "7/7 checks pass", "SoC"),
      PracticalStepEntity("s_12_3_3", "prac_12_3", 3, false, "નીચે અવલોકન કોષ્ટકમાં પાર્ટ્સ, બેટરી હેલ્થ અને ફાઇનલ ઇન્વોઇસ રકમ નોંધી ગ્રાહક ફીડબેક લો.", "नीचे अवलोकन में बदले गए पार्ट्स, बैटरी हेल्थ और इनवॉइस राशि दर्ज करें।", "Record tested voltages, temperature, and itemized invoice summary in Observation Entry below.", "રિપોર્ટ અને ઇન્વોઇસ સેવ", "रिपोर्ट व इनवॉइस सेव", "Invoice logged", "VRM"),

      // Prac 12.4
      PracticalStepEntity("s_12_4_1", "prac_12_4", 1, true, "સુરક્ષા: કોઈપણ ફૂલેલી Li-Ion બેટરીને તીક્ષ્ણ ધાતુથી અડશો નહીં — ફક્ત પ્લાસ્ટિક ટૂલ અને રેતીનું કન્ટેનર રાખો.", "सुरक्षा: फूली हुई Li-Ion बैटरी को धातु से न छुएं — प्लास्टिक टूल और रेत भरा बिन पास रखें।", "Safety Check: Never poke swollen Li-Ion batteries with metal; keep sand safety bin nearby.", "બેટરી સુરક્ષા OK", "बैटरी सुरक्षा OK", "Li-Ion safety ready", null),
      PracticalStepEntity("s_12_4_2", "prac_12_4", 2, false, "DMM ને 2MΩ પર મૂકી ESD પટ્ટાના બકલ થી એલિગેટર ક્લિપ વચ્ચે ~1.0 MΩ અવરોધ ચકાસો.", "DMM को 2MΩ पर रखकर ESD स्ट्रैप के बकल और क्लिप के बीच ~1.0 MΩ प्रतिरोध जांचें।", "Set DMM to 2MΩ and measure ~1.0 MΩ safety resistance across ESD wrist strap snap and clip.", "R_esd ≈ 1.0 MΩ", "R_esd ≈ 1.0 MΩ", "R_esd ≈ 1.0 MΩ", null),
      PracticalStepEntity("s_12_4_3", "prac_12_4", 3, false, "વર્કસ્ટેશન એર્ગોનોમિક્સ (20-20-20 નિયમ, સ્ક્રીન ઊંચાઈ) અને E-વેસ્ટ વર્ગીકરણ ઓડિટ પૂર્ણ કરો.", "कार्यस्थल एर्गोनॉमिक्स (20-20-20 नियम) और ई-कचरा/रीफर्बिश ऑडिट पूरा करें।", "Complete workstation ergonomics check (eye-level screen, 20-20-20 rule) & certified e-waste audit.", "ગ્રીન ઓડિટ 100%", "ग्रीन ऑडिट 100%", "Green audit pass", null),
    )
}
