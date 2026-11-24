package com.example.data.local

object SeedStd9And10 {

  private const val TRADE_9_10_GU = "જુનિયર ફિલ્ડ ટેકનિશિયન — હોમ એપ્લાયન્સિસ (PSSCIVE/NCERT)"
  private const val TRADE_9_10_HI = "जूनियर फील्ड तकनीशियन — होम अप्लायंसेज (PSSCIVE/NCERT)"
  private const val TRADE_9_10_EN = "Junior Field Technician Home Appliances (PSSCIVE/NCERT)"

  val lessons: List<LessonEntity> =
    listOf(
      // ==================== GRADE IX ====================
      LessonEntity(
        lessonId = "lesson_9_1",
        classStd = 9,
        chapterCode = "Std 9 • Module 1 (Sessions 1–4)",
        tradeNameGu = TRADE_9_10_GU,
        tradeNameHi = TRADE_9_10_HI,
        tradeNameEn = TRADE_9_10_EN,
        unitTitleGu = "મૂળભૂત ઇલેક્ટ્રિકલ અને ઇલેક્ટ્રોનિક્સ",
        unitTitleHi = "इलेक्ट्रिकल एवं इलेक्ट्रॉनिक्स के मूल सिद्धांत",
        unitTitleEn = "Fundamentals of Electrical and Electronics",
        titleGu = "મોડ્યુલ 1: ઇલેક્ટ્રિકલ-ઇલેક્ટ્રોનિક સર્કિટ, ઘટકો અને માપન સાધનો",
        titleHi = "मॉड्यूल 1: इलेक्ट्रिकल-इलेक्ट्रॉनिक सर्किट, घटक और मापन उपकरण",
        titleEn = "Module 1: Fundamentals of Electrical and Electronics",
        summaryGu =
          "જૂનિયર ટેકનિશિયનની ભૂમિકા, AC/DC સર્કિટ, રેઝિસ્ટર-કેપેસિટર-ડાયોડ-ટ્રાન્ઝિસ્ટર-IC અને મલ્ટિમીટરનો ઉપયોગ.",
        summaryHi =
          "जूनियर तकनीशियन की भूमिका, AC/DC सर्किट, रेजिस्टर-कैपेसिटर-डायोड-ट्रांजिस्टर-IC और मल्टीमीटर का उपयोग।",
        summaryEn =
          "Junior Technician roles, electrical & electronic circuits, passive/active components, and measuring instruments.",
        learningOutcomesGu =
          "• જુનિયર ફિલ્ડ ટેકનિશિયનની ફરજો અને ગ્રાહક સેવા સમજવી.\n• વોલ્ટેજ, કરંટ, અવરોધ અને સિરીઝ-પેરેલલ સર્કિટની ગણતરી કરવી.\n• રેઝિસ્ટર, કેપેસિટર, ઇન્ડક્ટર, ડાયોડ, LED, ટ્રાન્ઝિસ્ટર અને IC ઓળખવા.\n• મલ્ટિમીટર, ટેસ્ટર અને ટૂલ્સનો સુરક્ષિત ઉપયોગ કરવો.",
        learningOutcomesHi =
          "• जूनियर फील्ड तकनीशियन के कर्तव्य और कार्यस्थल अपेक्षाएं समझना।\n• वोल्टेज, करंट, रेजिस्टेंस और सीरीज़-पैरेलल सर्किट के नियम लागू करना।\n• रेजिस्टर, कैपेसिटर, इंडक्टर, डायोड, LED, ट्रांजिस्टर और IC की पहचान करना।\n• मल्टीमीटर और आवश्यक टूल्स का सही उपयोग करना।",
        learningOutcomesEn =
          "• Identify key duties and workplace expectations of a Junior Field Technician.\n• Understand voltage, current, resistance, Ohm's law, and series/parallel circuits.\n• Explain functions of resistors, capacitors, inductors, diodes, LEDs, transistors & ICs.\n• Demonstrate safe use of workshop tools and Digital Multimeters.",
        bodyGu =
          "📌 સેશન 1 — જુનિયર ફિલ્ડ ટેકનિશિયનની ભૂમિકા: ગ્રાહકના ઘરે જઈ ઉપકરણ તપાસવું, સુરક્ષા નિયમોનું પાલન કરવું, યોગ્ય સાધનો સાથે ખામી નિવારવી અને સર્વિસ રિપોર્ટ આપવો.\n\n📌 સેશન 2 — ઇલેક્ટ્રિકલ સર્કિટના મૂળભૂત સિદ્ધાંતો: બંધ પરિપથમાં ઇલેક્ટ્રોનના પ્રવાહને કરંટ (I, એમ્પીયર) કહે છે. વોલ્ટેજ (V) દબાણ છે અને અવરોધ (R, ઓહ્મ) પ્રવાહનો વિરોધ કરે છે. સિરીઝમાં કરંટ સમાન રહે છે; પેરેલલમાં વોલ્ટેજ સમાન રહે છે.\n\n📌 સેશન 3 — ઇલેક્ટ્રોનિક ઘટકો: પેસિવ ઘટકો (Resistor, Capacitor, Inductor) અને એક્ટિવ સેમિકન્ડક્ટર (PN Diode, LED, Transistor, IC). નીચેના ઇન્ટરેક્ટિવ ડાયાગ્રામ પર ટૅપ કરીને દરેક ઘટકનું સિમ્બોલ જુઓ.\n\n📌 સેશન 4 — સાધનો અને માપન: લાઇન ટેસ્ટર, કોમ્બિનેશન પ્લાયર, વાયર સ્ટ્રિપર, સોલ્ડરિંગ આયર્ન અને ડિજિટલ મલ્ટિમીટર (DMM).",
        bodyHi =
          "📌 सत्र 1 — जूनियर फील्ड तकनीशियन की भूमिका: ग्राहक के उपकरण की जांच, सुरक्षा नियमों का पालन, सही उपकरणों से मरम्मत और कार्य रिपोर्ट तैयार करना।\n\n📌 सत्र 2 — इलेक्ट्रिकल सर्किट के मूल सिद्धांत: बंद परिपथ में आवेश प्रवाह को करंट (I, एम्पीयर), विभवांतर को वोल्टेज (V) और रुकावट को रेजिस्टेंस (R, ओम) कहते हैं। सीरीज़ में करंट समान और पैरेलल में वोल्टेज समान रहता है।\n\n📌 सत्र 3 — इलेक्ट्रॉनिक सर्किट घटक: पैसिव घटक (Resistor, Capacitor, Inductor) तथा सेमीकंडक्टर (PN डायोड, LED, ट्रांजिस्टर, IC)। नीचे दिए इंटरैक्टिव सर्किट पर टैप कर सिंबल देखें।\n\n📌 सत्र 4 — टूल्स और मापन उपकरण: लाइन टेस्टर, प्लायर, वायर स्ट्रिपर, सोल्डरिंग आयरन और डिजिटल मल्टीमीटर (DMM)।",
        bodyEn =
          "📌 Session 1 — Roles & Responsibilities: Inspecting home appliances, communicating politely with customers, following electrical safety, and documenting repair reports.\n\n📌 Session 2 — Basics of Electrical Circuits: Closed loop flow of charge is Current (I, Amps) driven by Voltage (V, Volts) and opposed by Resistance (R, Ohms). Series shares current; parallel shares voltage.\n\n📌 Session 3 — Basics of Electronic Circuits: Passive parts (Resistor, Capacitor, Inductor) and active semiconductors (PN Diode, LED, Transistor, IC). Tap components in the schematic below to inspect symbols.\n\n📌 Session 4 — Tools & Measuring Instruments: Line tester, insulated pliers, wire stripper, soldering iron, clamp meter & Digital Multimeter (DMM).",
        equationsGu =
          "• ઓહ્મનો નિયમ: V = I × R  (I = V / R,  R = V / I)\n• વિદ્યુત પાવર: P = V × I = I² × R = V² / R  (વોટ)\n• સિરીઝ અવરોધ: R_total = R1 + R2 + R3\n• પેરેલલ અવરોધ: 1 / R_total = (1 / R1) + (1 / R2)\n• LED સીરીઝ રેઝિસ્ટર: R_s = (V_supply - V_LED) / I_LED",
        equationsHi =
          "• ओम का नियम: V = I × R  (I = V / R,  R = V / I)\n• विद्युत शक्ति (Power): P = V × I = I² × R = V² / R\n• सीरीज़ रेजिस्टेंस: R_total = R1 + R2 + R3\n• पैरेलल रेजिस्टेंस: 1 / R_total = (1 / R1) + (1 / R2)\n• LED सीरीज़ रेजिस्टर: R_s = (V_supply - V_LED) / I_LED",
        equationsEn =
          "• Ohm's Law: V = I × R  (I = V / R,  R = V / I)\n• Electrical Power: P = V × I = I² × R = V² / R  (Watts)\n• Series Resistance: R_total = R1 + R2 + R3\n• Parallel Resistance: 1 / R_total = (1 / R1) + (1 / R2)\n• LED Series Resistor: R_s = (V_supply - V_LED) / I_LED",
        impQuestionsGu =
          "Q: ઓહ્મનો નિયમ લખો અને 9V બેટરી સાથે 2V LED (20mA) માટે R શોધો.\nA: સ્થિર તાપમાને V = I × R. અહીં R = (9 - 2) / 0.02 = 350 Ω (માનક મૂલ્ય: 330 Ω).\n---\nQ: AC અને DC વચ્ચે મુખ્ય તફાવત શું છે?\nA: AC (Alternating Current) ની દિશા ભારતમાં 50 Hz આવૃત્તિથી બદલાય છે, જ્યારે DC (Direct Current) એક જ દિશામાં વહે છે.\n---\nQ: રેઝિસ્ટર, કેપેસિટર અને ડાયોડનું મુખ્ય કાર્ય શું છે?\nA: રેઝિસ્ટર કરંટ ઘટાડે છે, કેપેસિટર વિદ્યુત ચાર્જ સંગ્રહ કરે છે અને ડાયોડ કરંટને એક જ દિશામાં વહેવા દે છે.",
        impQuestionsHi =
          "Q: ओम का नियम लिखें तथा 9V बैटरी और 2V LED (20mA) के लिए R निकालें।\nA: नियत तापमान पर V = I × R। अतः R = (9 - 2) / 0.02 = 350 Ω (मानक मान: 330 Ω)।\n---\nQ: AC और DC में मुख्य अंतर क्या है?\nA: AC की दिशा भारत में 50 Hz आवृत्ति से बदलती रहती है, जबकि DC केवल एक दिशा में प्रवाहित होता है।\n---\nQ: रेजिस्टर, कैपेसिटर और डायोड का मुख्य कार्य क्या है?\nA: रेजिस्टर करंट सीमित करता है, कैपेसिटर आवेश संचित करता है और डायोड एक दिशा में करंट प्रवाहित करता है।",
        impQuestionsEn =
          "Q: State Ohm's Law and calculate series resistor for a 2V, 20mA LED on 9V DC.\nA: At constant temperature, V = I × R. R = (9V - 2V) / 0.02A = 350 Ω (nearest standard: 330 Ω).\n---\nQ: Differentiate between Series and Parallel circuits in home wiring.\nA: Series has one path (same current; one open breaks all). Home appliances use Parallel (same 230V; independent switches).\n---\nQ: What are active vs passive electronic components?\nA: Passive components (Resistor, Capacitor, Inductor) cannot amplify; Active components (Diode, Transistor, IC) control/amplify current.",
        rememberTipGu = "ઘરના બધા ઉપકરણો 230V AC પર પેરેલલ (Parallel) માં જોડાયેલા હોય છે જેથી એક બંધ થાય તો બીજું ચાલુ રહે.",
        rememberTipHi = "घरेलू उपकरण हमेशा 230V AC पर पैरेलल (समानांतर) में जोड़े जाते हैं ताकि प्रत्येक स्वतंत्र चले।",
        rememberTipEn = "Household outlets are always wired in Parallel at 230V AC, 50 Hz so each appliance operates independently.",
        glossaryGu = "ઓહ્મ (Ω): અવરોધનો એકમ • DMM: ડિજિટલ મલ્ટિમીટર • PN જંક્શન: ડાયોડનો મૂળ ભાગ",
        glossaryHi = "ओम (Ω): प्रतिरोध की इकाई • DMM: डिजिटल मल्टीमीटर • PN जंक्शन: डायोड का मूल भाग",
        glossaryEn = "Ohm (Ω): Unit of resistance • DMM: Digital Multimeter • Semiconductor: Silicon/Germanium junction device",
        circuitDiagramId = "circuit_led_series",
        linkedPracticalId = "prac_9_1",
        estimatedMinutes = 15,
        downloadSizeKb = 680,
        isDownloadedOffline = true,
        sortOrder = 1,
      ),

      LessonEntity(
        lessonId = "lesson_9_2",
        classStd = 9,
        chapterCode = "Std 9 • Module 2 (Sessions 1–3)",
        tradeNameGu = TRADE_9_10_GU,
        tradeNameHi = TRADE_9_10_HI,
        tradeNameEn = TRADE_9_10_EN,
        unitTitleGu = "LED લાઇટનું ઇન્સ્ટોલેશન અને રિપેરિંગ",
        unitTitleHi = "LED लाइट की स्थापना और मरम्मत",
        unitTitleEn = "Installation and Repairing of LED Light",
        titleGu = "મોડ્યુલ 2: LED લાઇટના પ્રકાર, ઇન્સ્ટોલેશન અને ડ્રાઇવર રિપેરિંગ",
        titleHi = "मॉड्यूल 2: LED लाइट के मूल सिद्धांत, इंस्टॉलेशन और रिपेयरिंग",
        titleEn = "Module 2: Installation and Repairing of LED Light",
        summaryGu = "LED બલ્બ/ટ્યુબની રચના, લ્યુમેન કાર્યક્ષમતા, B22/ડાઉનલાઇટ ઇન્સ્ટોલેશન અને ડ્રાઇવર ફોલ્ટ નિવારણ.",
        summaryHi = "LED बल्ब/ट्यूब की संरचना, लुमेन दक्षता, इंस्टॉलेशन और ड्राइवर फॉल्ट रिपेयर।",
        summaryEn = "LED light construction, lumen efficacy, indoor/outdoor installation, and MCPCB/driver troubleshooting.",
        learningOutcomesGu =
          "• LED બલ્બના મુખ્ય ભાગો (ડિફ્યુઝર, MCPCB, હીટ-સિંક, ડ્રાઇવર, B22 કેપ) સમજવા.\n• સુરક્ષિત રીતે LED બલ્બ, બેટન ટ્યુબ અને પેનલ લાઇટ ઇન્સ્ટોલ કરવી.\n• ડેડ કે ઝબકતા (Flickering) LED બલ્બનું સમારકામ કરવું.",
        learningOutcomesHi =
          "• LED बल्ब के भाग (डिफ्यूज़र, MCPCB, हीट-सिंक, ड्राइवर, B22 कैप) पहचानना।\n• LED ट्यूब लाइट और पैनल लाइट को सुरक्षित इंस्टॉल करना।\n• बंद या झिलमिलाते LED बल्ब की जांच और मरम्मत करना।",
        learningOutcomesEn =
          "• Explain LED construction: diffuser, aluminum MCPCB, heatsink, constant-current driver & B22 cap.\n• Install LED battens, ceiling panels, and fixtures safely.\n• Diagnose and repair dead or flickering LED bulbs using a Series Test Lamp and DMM.",
        bodyGu =
          "📌 સેશન 1 — LED લાઇટના મૂળભૂત સિદ્ધાંતો: LED એ ઇલેક્ટ્રોલ્યુમિનેસેન્સ સિદ્ધાંત પર કામ કરે છે. CFL/ઇન્કેન્ડેસેન્ટ કરતાં 80% ઓછી વીજળી વાપરે છે અને તેમાં પારો (Mercury) હોતો નથી.\n\n📌 સેશન 2 — LED લાઇટ ઇન્સ્ટોલેશન: ફેઝ-ન્યુટ્રલ કાળજીપૂર્વક જોડવું, સીલિંગ કટ-આઉટ માપવું, અને ડ્રાઇવર આઉટપુટ (+ / -) પોલેરિટી મુજબ પેનલ સાથે જોડવું.\n\n📌 સેશન 3 — LED ટ્રબલશૂટિંગ અને રિપેરિંગ: (1) બિલકુલ ચાલુ ન થાય → ફ્યુઝિબલ રેઝિસ્ટર F1 અથવા બ્રિજ BR1 તપાસો; (2) ધીમો પ્રકાશ/ઝબકે → ફિલ્ટર કેપેસિટર C1 અથવા MCPCB માં કાળો પડેલ SMD LED બદલો.",
        bodyHi =
          "📌 सत्र 1 — LED लाइट के मूल सिद्धांत: LED इलेक्ट्रोल्यूमिनेसेंस पर कार्य करती है, पारा-रहित है और साधारण बल्ब से ~80% बिजली बचाती है।\n\n📌 सत्र 2 — LED लाइट इंस्टॉलेशन: मेन MCB बंद कर बैटन क्लिप लगाना, फेज-न्यूट्रल जोड़ना और ड्राइवर आउटपुट (+/-) सही ध्रुवता से लगाना।\n\n📌 सत्र 3 — LED रिपेयरिंग: (1) बल्ब बिल्कुल न जले → फ्यूज़िबल रेजिस्टर F1 या ब्रिज BR1 जांचें; (2) झिलमिलाहट हो → कैपेसिटर C1 या काले धब्बे वाला SMD LED बदलें।",
        bodyEn =
          "📌 Session 1 — Basics of LED Light: Works on electroluminescence, mercury-free, and uses up to 80% less power than incandescent lamps.\n\n📌 Session 2 — Installation: Isolate MCB, mount batten clips/ceiling cutout, connect Live/Neutral, and match driver DC (+/-) output.\n\n📌 Session 3 — Troubleshooting & Repair: Dead bulb → check F1 fusible resistor & BR1 bridge; Flickering/dim → check C1 electrolytic capacitor & blackened SMD LEDs on MCPCB.",
        equationsGu =
          "• લ્યુમિનસ એફિકસી: Efficacy = Total Lumens (lm) / Input Power (Watt)\n• પાવર વપરાશ (કિલોવોટ-અવર): Units (kWh) = (Watt × Hours) / 1000\n• સીરીઝ MCPCB વોલ્ટેજ: V_total = n × V_SMD  (દા.ત. 9 LED × 9V = 81V DC)",
        equationsHi =
          "• ल्यूमिनस एफिशिएंसी: Efficacy = कुल ल्यूमेन (lm) / पावर (Watt)\n• ऊर्जा खपत (यूनिट): Units (kWh) = (Watt × Hours) / 1000\n• सीरीज़ MCPCB वोल्टेज: V_total = n × V_SMD  (उदा. 9 LED × 9V = 81V DC)",
        equationsEn =
          "• Luminous Efficacy: Efficacy = Total Lumens (lm) / Power (W)  [e.g., 900 lm / 9W = 100 lm/W]\n• Energy Consumed: Units (kWh) = (Watt × Hours) / 1000\n• Series MCPCB String: V_string = n × V_chip  (e.g., 9 × 9V = 81V DC)",
        impQuestionsGu =
          "Q: જો 9W LED બલ્બમાં ફક્ત 1 SMD LED બળી જાય તો આખો બલ્બ કેમ બંધ થઈ જાય છે?\nA: કારણ કે MCPCB પર બધા SMD LED શ્રેણી (Series) માં જોડાયેલા હોય છે; એક ખુલ્લો (Open) થવાથી આખો પરિપથ તૂટી જાય છે.\n---\nQ: LED બલ્બમાં એલ્યુમિનિયમ હીટ-સિંક અને MCPCB કેમ વપરાય છે?\nA: SMD LED માં ઉત્પન્ન થતી ગરમી ઝડપથી બહાર ફેંકવા માટે, જેથી LED ની આવરદા (Lifespan) વધે.\n---\nQ: સીરીઝ ટેસ્ટ લેમ્પથી LED બલ્બ તપાસવાનો ફાયદો શું છે?\nA: જો બલ્બમાં અંદર શોર્ટ સર્કિટ હોય તો ટેસ્ટ લેમ્પ પૂરો પ્રકાશિત થાય છે અને MCB ટ્રીપ કે સ્પાર્ક થતા અટકે છે.",
        impQuestionsHi =
          "Q: 9W LED बल्ब में केवल एक SMD LED खराब होने पर पूरा बल्ब क्यों बंद हो जाता है?\nA: क्योंकि MCPCB पर सभी SMD LED सीरीज़ में जुड़े होते हैं; एक ओपन होने से पूरा सर्किट टूट जाता है।\n---\nQ: LED बल्ब में एल्युमिनियम हीट-सिंक का क्या कार्य है?\nA: यह LED चिप की गर्मी को अवशोषित कर बाहर निकालता है जिससे बल्ब जल्दी खराब नहीं होता।\n---\nQ: फ्यूज़िबल रेजिस्टर F1 और MOV का क्या उपयोग है?\nA: MOV अधिक वोल्टेज सर्ज को रोकता है और F1 ओवर-करंट पर ओपन होकर ड्राइवर को बचाता है।",
        impQuestionsEn =
          "Q: Why does a whole 9W LED bulb stop glowing when just one SMD LED burns out?\nA: SMD LEDs on the MCPCB are wired in Series; one open-circuited chip breaks the current path.\n---\nQ: Why is thermal paste applied between the MCPCB and aluminum housing?\nA: To eliminate air gaps and conduct heat efficiently into the heatsink, extending LED life.\n---\nQ: What is the role of the Fusible Resistor (F1) in an LED driver?\nA: It acts as a protective fuse that opens safely during short circuits or voltage spikes.",
        rememberTipGu = "ક્યારેય બળેલા SMD LED ને સોલ્ડરથી સીધો શોર્ટ કરીને છોડશો નહીં — વધારાનો વોલ્ટેજ બાકીના LED ને જલ્દી બાળી નાખશે.",
        rememberTipHi = "खराब SMD LED को केवल सोल्डर से शॉर्ट न करें; नया SMD LED या MCPCB बदलना ही सही तरीका है।",
        rememberTipEn = "Avoid permanently shorting a dead SMD LED with solder; replace the chip or MCPCB to prevent overdriving remaining LEDs.",
        glossaryGu = "MCPCB: મેટલ કોર પ્રિન્ટેડ સર્કિટ બોર્ડ • ડિફ્યુઝર: પ્રકાશ ફેલાવતું કવર • લ્યુમેન: પ્રકાશનું માપ",
        glossaryHi = "MCPCB: मेटल कोर PCB • डिफ्यूज़र: प्रकाश फैलाने वाला कवर • ल्यूमेन: प्रकाश तीव्रता इकाई",
        glossaryEn = "MCPCB: Metal Core PCB • Diffuser: Glare-reducing dome • Lumen: Unit of luminous flux",
        circuitDiagramId = "circuit_led_bulb_driver",
        linkedPracticalId = "prac_9_3",
        estimatedMinutes = 14,
        downloadSizeKb = 720,
        isDownloadedOffline = true,
        sortOrder = 2,
      ),

      LessonEntity(
        lessonId = "lesson_9_3",
        classStd = 9,
        chapterCode = "Std 9 • Module 3 (Sessions 1–2)",
        tradeNameGu = TRADE_9_10_GU,
        tradeNameHi = TRADE_9_10_HI,
        tradeNameEn = TRADE_9_10_EN,
        unitTitleGu = "વ્યાવસાયિક આરોગ્ય, સુરક્ષા અને ગ્રીન પ્રેક્ટિસ",
        unitTitleHi = "व्यावसायिक स्वास्थ्य, सुरक्षा एवं हरित कार्यप्रणाली",
        unitTitleEn = "Occupational Health and Safety Standards",
        titleGu = "મોડ્યુલ 3: વર્કપ્લેસ સેફ્ટી, PPE, આગ સુરક્ષા અને E-વેસ્ટ મેનેજમેન્ટ",
        titleHi = "मॉड्यूल 3: कार्यस्थल सुरक्षा, PPE, अग्नि सुरक्षा और ई-कचरा प्रबंधन",
        titleEn = "Module 3: Occupational Health, Safety & Green Practices",
        summaryGu = "ઇલેક્ટ્રિક શોકથી બચાવ, PPE કિટ, આગના પ્રકાર (Class A/B/C/E), 5S અને E-વેસ્ટ રિસાયક્લિંગ.",
        summaryHi = "विद्युत झटके से बचाव, PPE किट, आग के प्रकार (Class A/B/C/E), 5S और ई-कचरा रीसाइक्लिंग।",
        summaryEn = "Electrical hazard prevention, PPE gear, fire extinguisher classes, First Aid, and green e-waste disposal.",
        learningOutcomesGu =
          "• ઇલેક્ટ્રિકલ શોક, બર્ન અને વર્કશોપ અકસ્માતો અટકાવવાના નિયમો પાળવા.\n• યોગ્ય PPE (રબર ગ્લોવ્ઝ, ઇન્સ્યુલેટેડ શૂઝ, સેફ્ટી ગોગલ્સ) પસંદ કરવા.\n• ઇલેક્ટ્રિકલ આગ માટે CO₂ / DCP અગ્નિશામકનો ઉપયોગ અને E-વેસ્ટ અલગ પાડવું.",
        learningOutcomesHi =
          "• कार्यस्थल पर विद्युत और यांत्रिक खतरों से बचाव के नियम अपनाना।\n• सही PPE (रबर दस्ताने, इंसुलेटेड जूते, चश्मा) का चयन करना।\n• बिजली की आग बुझाने की सही विधि और ई-कचरा प्रबंधन समझना।",
        learningOutcomesEn =
          "• Prevent electrical shock, thermal burns, and mechanical workshop hazards.\n• Select proper PPE: insulated gloves, rubber-soled shoes, safety goggles.\n• Match fire extinguisher types (CO₂/Dry Powder for electrical fires) and segregate e-waste.",
        bodyGu =
          "📌 સેશન 1 — વર્કપ્લેસ હેલ્થ એન્ડ સેફ્ટી: કામ પહેલાં મેઇન સ્વિચ/MCB બંધ કરી LOTO (Lock-Out Tag-Out) લગાવો. ભીના હાથે ક્યારેય ઉપકરણ ન અડશો. શોક લાગ્યો હોય તો લાકડા/પ્લાસ્ટિકની સૂકી લાકડીથી વ્યક્તિને અલગ કરો અને CPR/ફર્સ્ટ એઇડ આપો.\n\n📌 આગ સુરક્ષા: લાકડું/કાગળ (Class A), તેલ (Class B), ગેસ (Class C), ઇલેક્ટ્રિકલ આગ માટે ક્યારેય પાણી ન નાખો — ફક્ત CO₂ અથવા Dry Chemical Powder (DCP) વાપરો!\n\n📌 સેશન 2 — વેસ્ટ મેનેજમેન્ટ અને ગ્રીન પ્રેક્ટિસ: ખરાબ PCB, કેપેસિટર, બેટરી અને ટ્યુબલાઇટ (E-Waste) ને સામાન્ય કચરામાં ન ફેંકો. 3R સિદ્ધાંત (Reduce, Reuse, Recycle) અપનાવો.",
        bodyHi =
          "📌 सत्र 1 — कार्यस्थल स्वास्थ्य एवं सुरक्षा: कार्य से पहले MCB बंद करें और रबर मैट/जूते पहनें। करंट लगने पर सूखी लकड़ी से संपर्क तोड़ें। बिजली की आग पर कभी पानी न डालें — केवल CO₂ या Dry Powder फायर एक्सटिंग्विशर प्रयोग करें।\n\n📌 सत्र 2 — ई-कचरा प्रबंधन और हरित अभ्यास: खराब PCB, बैटरी, LED और सीसा युक्त सोल्डर कचरे को अलग बिन में रखें। 3R (Reduce, Reuse, Recycle) सिद्धांत अपनाकर पर्यावरण बचाएं।",
        bodyEn =
          "📌 Session 1 — Workplace Health & Safety: Isolate MCB before servicing, wear insulated shoes/gloves, and keep floor dry. Never pour water on an energized electrical fire—use CO₂ or Dry Chemical Powder (DCP).\n\n📌 Session 2 — Waste Management & Green Practices: Segregate hazardous e-waste (PCBs, batteries, solder dross, mercury CFLs) from general waste and follow the 3Rs (Reduce, Reuse, Recycle).",
        equationsGu =
          "• માનવ સુરક્ષા કરંટ મર્યાદા: < 5 mA (સુરક્ષિત), > 30 mA AC (જીવલેણ — ELCB/RCCB ટ્રીપ)\n• 3R ગ્રીન ફોર્મ્યુલા: Reduce (ઘટાડો) + Reuse (ફરી વાપરો) + Recycle (રિસાયકલ)\n• અર્થ રેઝિસ્ટન્સ: R_earth < 1 Ω – 2 Ω (સુરક્ષિત ઘરેલું અર્થિંગ)",
        equationsHi =
          "• सुरक्षित मानव करंट सीमा: < 5 mA, > 30 mA AC घातक (RCCB 30mA पर ट्रिप)\n• 3R नियम: Reduce (कम उपयोग) + Reuse (पुनः उपयोग) + Recycle (पुनर्चक्रण)\n• अर्थ रेजिस्टेंस: R_earth < 1 Ω – 2 Ω",
        equationsEn =
          "• Human Shock Threshold: > 30 mA AC is hazardous (RCCB/ELCB trips at 30 mA)\n• Safe Earth Resistance: R_earth < 1 Ω – 2 Ω\n• Green Rule: 3R = Reduce, Reuse, Recycle (Authorized E-Waste Recycler)",
        impQuestionsGu =
          "Q: ઇલેક્ટ્રિકલ પેનલ કે ઉપકરણમાં લાગેલી આગ પર પાણી કેમ ન નાખવું જોઈએ?\nA: પાણી વીજળીનું સુવાહક છે, જેનાથી આગ બુઝાવનારને જીવલેણ ઇલેક્ટ્રિક શોક લાગી શકે છે. CO₂ વાપરવો જોઈએ.\n---\nQ: RCCB / ELCB નું પૂરું નામ અને કાર્ય શું છે?\nA: Residual Current Circuit Breaker — 30mA જેટલું અર્થ લીકેજ થતાં જ મિલીસેકન્ડમાં પાવર બંધ કરી જીવ બચાવે છે.\n---\nQ: E-વેસ્ટ (E-Waste) ને સામાન્ય કચરામાં કેમ ન નાખવો જોઈએ?\nA: તેમાં સીસું (Lead), પારો અને કેડમિયમ જેવા ઝેરી તત્વો હોય છે જે જમીન અને પાણીને પ્રદૂષિત કરે છે.",
        impQuestionsHi =
          "Q: बिजली से लगी आग पर पानी क्यों नहीं डालना चाहिए?\nA: पानी विद्युत का सुचालक है जिससे आग बुझाने वाले को गंभीर करंट लग सकता है; इसके लिए CO₂ उपयोग करें।\n---\nQ: RCCB का पूरा नाम और कार्य क्या है?\nA: Residual Current Circuit Breaker — यह लीकेज करंट होने पर मिलीसेकंड में सप्लाई काटकर करंट लगने से बचाता है।\n---\nQ: ई-कचरा (E-Waste) क्या है?\nA: बेकार इलेक्ट्रॉनिक उपकरण (PCB, बैटरी, LED, केबल) जिन्हें अधिकृत रीसाइक्लिंग केंद्र को देना चाहिए।",
        impQuestionsEn =
          "Q: Which fire extinguisher is safe for live electrical equipment fires?\nA: CO₂ (Carbon Dioxide) or ABC Dry Chemical Powder — never water or foam.\n---\nQ: What does PPE stand for? Name 3 items for an electronics technician.\nA: Personal Protective Equipment: insulated rubber gloves, safety goggles, and rubber-soled shoes.\n---\nQ: Why must lead solder waste and batteries be separated as E-Waste?\nA: They contain toxic heavy metals (lead, lithium, cadmium) that contaminate soil and groundwater.",
        rememberTipGu = "કોઈપણ જીવંત વાયરને અડતા પહેલાં 'એક હાથનો નિયમ' (એક હાથ ખિસ્સામાં/દૂર) અને રબરના ચંપલ રાખો.",
        rememberTipHi = "हमेशा टेस्टर से जांचकर और सूखे रबर जूतों के साथ ही विद्युत पैनल पर कार्य करें।",
        rememberTipEn = "Remember PASS for extinguishers: Pull pin, Aim at base, Squeeze handle, Sweep side to side.",
        glossaryGu = "PPE: વ્યક્તિગત સુરક્ષા સાધનો • RCCB: લીકેજ સુરક્ષા બ્રેકર • E-Waste: ઇલેક્ટ્રોનિક કચરો",
        glossaryHi = "PPE: व्यक्तिगत सुरक्षा उपकरण • RCCB: अर्थ लीकेज ब्रेकर • E-Waste: इलेक्ट्रॉनिक कचरा",
        glossaryEn = "PPE: Personal Protective Equipment • LOTO: Lock-Out Tag-Out • E-Waste: Discarded electronics",
        circuitDiagramId = null,
        linkedPracticalId = "prac_9_4",
        estimatedMinutes = 10,
        downloadSizeKb = 490,
        isDownloadedOffline = true,
        sortOrder = 3,
      ),

      // ==================== GRADE X ====================
      LessonEntity(
        lessonId = "lesson_10_1",
        classStd = 10,
        chapterCode = "Std 10 • Module 1 (Sessions 1–2)",
        tradeNameGu = TRADE_9_10_GU,
        tradeNameHi = TRADE_9_10_HI,
        tradeNameEn = TRADE_9_10_EN,
        unitTitleGu = "ઇલેક્ટ્રિક આયર્ન (ઇસ્ત્રી) ઇન્સ્ટોલેશન અને રિપેરિંગ",
        unitTitleHi = "इलेक्ट्रिक आयरन की स्थापना, मरम्मत एवं रखरखाव",
        unitTitleEn = "Installation, Repair and Maintenance of Electric Iron",
        titleGu = "મોડ્યુલ 1: ઇલેક્ટ્રિક આયર્નની રચના, થર્મોસ્ટેટ અને ફોલ્ટ રિપેરિંગ",
        titleHi = "मॉड्यूल 1: इलेक्ट्रिक आयरन का संचालन, थर्मोस्टेट और रिपेयरिंग",
        titleEn = "Module 1: Electric Iron Operation, Thermostat & Repair",
        summaryGu = "ડ્રાય અને સ્ટીમ આયર્નના ભાગો, નાઇક્રોમ એલિમેન્ટ, બાયમેટાલિક થર્મોસ્ટેટ, થર્મલ ફ્યુઝ અને અર્થ લીકેજ ટેસ્ટ.",
        summaryHi = "ड्राई और स्टीम आयरन के भाग, नाइक्रोम एलिमेंट, थर्मोस्टेट, थर्मल फ्यूज़ और अर्थ लीकेज परीक्षण।",
        summaryEn = "Dry/steam iron operation, soleplate heating element, bimetallic thermostat calibration, and fault diagnosis.",
        learningOutcomesGu =
          "• ઇલેક્ટ્રિક આયર્નનો સુરક્ષિત ઉપયોગ અને તાપમાન સેટિંગ (Silk, Wool, Cotton) સમજવું.\n• થર્મલ ફ્યુઝ, થર્મોસ્ટેટ અને હીટિંગ એલિમેન્ટની કન્ટિન્યુઇટી તપાસવી.\n• બોડીમાં શોક આવતો હોય તો અર્થિંગ અને ઇન્સ્યુલેશન ફોલ્ટ દૂર કરવો.",
        learningOutcomesHi =
          "• इलेक्ट्रिक आयरन के सही संचालन व तापमान सेटिंग (Silk, Wool, Cotton) को समझना।\n• थर्मल फ्यूज़, थर्मोस्टेट और हीटिंग एलिमेंट का परीक्षण करना।\n• बॉडी करंट (अर्थ लीकेज) और हीटिंग न होने के दोष दूर करना।",
        learningOutcomesEn =
          "• Explain setup, fabric temperature settings, and steam functions of an electric iron.\n• Diagnose non-heating, overheating, and earth-leakage faults.\n• Replace faulty power cords, thermal fuses, or heating elements safely.",
        bodyGu =
          "📌 સેશન 1 — ઇન્સ્ટોલેશન અને ઓપરેશન: આયર્ન 750W થી 1200W લોડ લે છે તેથી 3-પિન અર્થ્ડ 6A/16A સોકેટ વાપરો. સ્ટીમ આયર્નમાં સ્કેલિંગ અટકાવવા ડિસ્ટિલ્ડ વોટર વાપરો.\n\n📌 સેશન 2 — ટ્રબલશૂટિંગ અને રિપેરિંગ:\n1) આયર્ન બિલકુલ ગરમ ન થાય → કોર્ડ વાયર, થર્મલ ફ્યુઝ TF1, થર્મોસ્ટેટ કોન્ટેક્ટ અથવા હીટિંગ એલિમેન્ટ HE1 ઓપન હોઈ શકે.\n2) વધુ પડતું ગરમ થાય → બાયમેટાલિક થર્મોસ્ટેટ TH1 ના પોઇન્ટ ચોંટી ગયા હોય; સેન્ડપેપરથી સાફ કરો અથવા થર્મોસ્ટેટ બદલો.\n3) બોડીમાં કરંટ લાગે → માઇકા ઇન્સ્યુલેશન અથવા કોર્ડ અર્થિંગ તપાસો.",
        bodyHi =
          "📌 सत्र 1 — संचालन एवं स्थापना: आयरन 750W–1200W का उपकरण है, इसलिए हमेशा 3-पिन अर्थिंग सॉकेट उपयोग करें। स्टीम आयरन में डिस्टिल्ड जल भरें।\n\n📌 सत्र 2 — दोष निवारण और मरम्मत:\n1) आयरन गर्म न हो → पावर कॉर्ड, थर्मल फ्यूज़ TF1, थर्मोस्टेट या हीटिंग एलिमेंट HE1 की जांच करें।\n2) अधिक गर्म हो (कट न करे) → थर्मोस्टेट कॉन्टैक्ट चिपके हैं, उन्हें साफ करें या बदलें।\n3) बॉडी में करंट आए → हीटिंग एलिमेंट और सोलप्लेट के बीच अर्थ लीकेज जांचें।",
        bodyEn =
          "📌 Session 1 — Installation & Operation: Electric irons draw 750W–1200W and require a 3-pin earthed socket. Steam irons use distilled water to prevent mineral scaling.\n\n📌 Session 2 — Troubleshooting & Repair:\n• No Heat: Test mains cord, Thermal Fuse (TF1), Thermostat (TH1), and Heating Element (HE1) for continuity.\n• Overheating: Bimetallic contacts welded shut—clean or recalibrate thermostat.\n• Shock on Body: Insulation breakdown between element and soleplate—verify OL resistance to body.",
        equationsGu =
          "• જૂલ ઉષ્મા નિયમ: H = I² × R × t  (જૂલ)\n• એલિમેન્ટ અવરોધ: R = V² / P  (દા.ત. 230² / 1000W ≈ 52.9 Ω)\n• આયર્ન કરંટ: I = P / V = 1000W / 230V ≈ 4.35 A",
        equationsHi =
          "• जूल ऊष्मा नियम: H = I² × R × t  (जूल)\n• हीटिंग एलिमेंट का प्रतिरोध: R = V² / P  (उदा. 230² / 1000W ≈ 52.9 Ω)\n• करंट: I = P / V = 1000W / 230V ≈ 4.35 A",
        equationsEn =
          "• Joule's Law of Heating: H = I² × R × t  (Joules)\n• Element Resistance: R = V² / P  (e.g., 230² / 1000W ≈ 52.9 Ω)\n• Rated Current: I = P / V = 1000W / 230V ≈ 4.35 A",
        impQuestionsGu =
          "Q: ઇલેક્ટ્રિક આયર્નમાં થર્મલ ફ્યુઝ અને થર્મોસ્ટેટ વચ્ચે શું તફાવત છે?\nA: થર્મોસ્ટેટ વારંવાર તાપમાન મુજબ ON-OFF થાય છે; થર્મલ ફ્યુઝ (240°C) એકવાર ઓગળીને ઓવરહીટ આગથી કાયમી સુરક્ષા આપે છે.\n---\nQ: 1000W, 230V ના આયર્નના હીટિંગ એલિમેન્ટનો અવરોધ મલ્ટિમીટરમાં કેટલો બતાવવો જોઈએ?\nA: R = 230² / 1000 ≈ 53 Ω.\n---\nQ: સ્ટીમ આયર્નના સોલપ્લેટના છિદ્રો બંધ થઈ જાય તો શું કરવું?\nA: સોલપ્લેટ સાફ કરવી અને હંમેશા ફિલ્ટર્ડ કે ડિસ્ટિલ્ડ પાણી વાપરવું.",
        impQuestionsHi =
          "Q: इलेक्ट्रिक आयरन में थर्मोस्टेट और थर्मल फ्यूज़ में क्या अंतर है?\nA: थर्मोस्टेट तापमान के अनुसार बार-बार कट-ऑफ होता है, जबकि थर्मल फ्यूज़ (240°C) खराबी की स्थिति में एक बार ओपन होकर आग से बचाता है।\n---\nQ: 1000W, 230V आयरन के हीटिंग एलिमेंट का रेजिस्टेंस लगभग कितना होता है?\nA: R = V²/P = 230²/1000 ≈ 52.9 Ω।\n---\nQ: आयरन में नाइक्रोम और माइका (अभ्रक) का उपयोग क्यों होता है?\nA: नाइक्रोम उच्च प्रतिरोध व ऊष्मा देता है और माइका ऊष्मा का सुचालक पर बिजली का कुचालक है।",
        impQuestionsEn =
          "Q: Why is Mica used around the Nichrome heating wire inside an iron?\nA: Mica conducts heat to the soleplate while acting as a high-temperature electrical insulator.\n---\nQ: What resistance should a healthy 1000W, 230V heating element show on a DMM?\nA: R = V² / P = 230² / 1000 ≈ 53 Ω (and Infinite/OL to the metal soleplate).\n---\nQ: Why does a neon indicator stay ON even when the iron isn't heating?\nA: If the neon glows normally across terminals but soleplate stays cold, the heating element HE1 is open.",
        rememberTipGu = "કોઈપણ આયર્ન રિપેર કર્યા પછી પ્લગની મોટી અર્થ પિન અને સોલપ્લેટ વચ્ચે બીપ (Continuity) ખાસ ચકાસો.",
        rememberTipHi = "रिपेयरिंग के बाद अर्थ पिन से मेटल सोलप्लेट तक कंटिन्यूटी (<1 Ω) अवश्य जांचें।",
        rememberTipEn = "Always verify <1 Ω Earth continuity to the soleplate and OL (no leak) from Live/Neutral to body!",
        glossaryGu = "સોલપ્લેટ: નીચેની ગરમ પ્લેટ • બાયમેટાલિક પટ્ટી: તાપમાન નિયંત્રક • નાઇક્રોમ: ગરમ થતો તાર",
        glossaryHi = "सोलप्लेट: निचली गर्म प्लेट • बायमेटैलिक स्ट्रिप: थर्मोस्टेट पट्टी • नाइक्रोम: हीटिंग तार",
        glossaryEn = "Soleplate: Heated ironing base • Bimetallic Strip: Thermal switch • Nichrome: Ni-Cr heating alloy",
        circuitDiagramId = "circuit_electric_iron",
        linkedPracticalId = "prac_10_1",
        estimatedMinutes = 14,
        downloadSizeKb = 650,
        isDownloadedOffline = true,
        sortOrder = 4,
      ),

      LessonEntity(
        lessonId = "lesson_10_2",
        classStd = 10,
        chapterCode = "Std 10 • Module 2 (Sessions 1–2)",
        tradeNameGu = TRADE_9_10_GU,
        tradeNameHi = TRADE_9_10_HI,
        tradeNameEn = TRADE_9_10_EN,
        unitTitleGu = "ઇલેક્ટ્રિક ફેન ઇન્સ્ટોલેશન અને રિપેરિંગ",
        unitTitleHi = "इलेक्ट्रिक फैन की स्थापना, मरम्मत एवं रखरखाव",
        unitTitleEn = "Installation, Repair and Maintenance of Electric Fan",
        titleGu = "મોડ્યુલ 2: સિલિંગ/પેડેસ્ટલ ફેન ઇન્સ્ટોલેશન, કેપેસિટર અને મોટર રિપેર",
        titleHi = "मॉड्यूल 2: इलेक्ट्रिक फैन इंस्टॉलेशन, कैपेसिटर और वाइंडिंग रिपेयर",
        titleEn = "Module 2: Electric Fan Installation, Capacitor & Troubleshooting",
        summaryGu = "સિંગલ-ફેઝ ઇન્ડક્શન મોટર, સ્ટાર્ટિંગ/રનિંગ વાઇન્ડિંગ, 2.5µF કેપેસિટર, રેગ્યુલેટર અને બેરિંગ અવાજ નિવારણ.",
        summaryHi = "सिंगल-फेज मोटर, स्टार्टिंग/रनिंग वाइंडिंग, 2.5µF कैपेसिटर, रेगुलेटर और बेयरिंग शोर निवारण।",
        summaryEn = "Ceiling/pedestal fan mounting, single-phase induction windings, 2.5µF capacitor test, and bearing care.",
        learningOutcomesGu =
          "• સિલિંગ ફેનનું સુરક્ષિત માઉન્ટિંગ (ડાઉનરોડ, શેકલ, બ્લેડ) કરવું.\n• મલ્ટિમીટરથી Common, Starting અને Running વાઇન્ડિંગ ઓળખવા.\n• ધીમા ચાલતા, ગુંજતા (Humming) અથવા ઊલટા ફરતા પંખાનું સમારકામ કરવું.",
        learningOutcomesHi =
          "• सीलिंग फैन की सुरक्षित स्थापना और रेगुलेटर कनेक्शन करना।\n• मल्टीमीटर से कॉमन, स्टार्टिंग और रनिंग वाइंडिंग की पहचान करना।\n• धीमे चलने, हमिंग करने या उल्टा घूमने वाले पंखे को ठीक करना।",
        learningOutcomesEn =
          "• Mount ceiling fans safely with shackle pin, safety wire, and balanced blades.\n• Identify Common, Starting, and Running leads using a Digital Multimeter.\n• Troubleshoot slow speed, humming, noisy bearings, and reverse rotation.",
        bodyGu =
          "📌 સેશન 1 — ઇલેક્ટ્રિક ફેન ઇન્સ્ટોલેશન: ડાઉનરોડમાં નટ-બોલ્ટ સાથે કોટર પિન (Split Pin) લગાવવી ફરજિયાત છે. ઇલેક્ટ્રોનિક ટ્રાયક રેગ્યુલેટર હંમેશા ફેઝ લાઇનમાં જોડવામાં આવે છે.\n\n📌 સેશન 2 — ટ્રબલશૂટિંગ:\n• પંખો ધીમો ફરે → 2.5 µF કેપેસિટર નબળો પડ્યો હોય અથવા બોલ બેરિંગ જામ હોય.\n• પંખો ગુંજે પણ ફરે નહીં → કેપેસિટર ઓપન અથવા સ્ટાર્ટિંગ વાઇન્ડિંગ ખુલ્લી હોય.\n• પંખો ઊલટો ફરે → કેપેસિટર સાથે જોડાયેલા સ્ટાર્ટિંગ/રનિંગ લીડ અદલાબદલી કરો.",
        bodyHi =
          "📌 सत्र 1 — इलेक्ट्रिक फैन इंस्टॉलेशन: डाउनरोड के बोल्ट में स्प्लिट पिन लगाना अनिवार्य है। रेगुलेटर को हमेशा फेज तार के सीरीज़ में जोड़ें।\n\n📌 सत्र 2 — दोष निवारण:\n• पंखा धीमा चले → 2.5 µF कैपेसिटर कमजोर हो गया है या बेयरिंग जाम है।\n• केवल हमिंग (आवाज़) करे → कैपेसिटर खराब या स्टार्टिंग वाइंडिंग ओपन है।\n• उल्टा घूमे → टर्मिनल ब्लॉक पर स्टार्टिंग व रनिंग तार आपस में बदलें।",
        bodyEn =
          "📌 Session 1 — Installation: Always lock downrod bolt with a cotter/split pin and wire the Triac regulator in series with the Live phase.\n\n📌 Session 2 — Troubleshooting:\n• Slow Speed: Degraded 2.5 µF capacitor or dry ball bearings (6201/6202).\n• Humming Without Spin: Open capacitor or open starting coil.\n• Reverse Rotation: Swap the starting and running capacitor leads at the terminal connector.",
        equationsGu =
          "• કેપેસિટિવ રિએક્ટન્સ: X_c = 1 / (2 × π × f × C)  (50Hz, 2.5µF માટે ≈ 1273 Ω)\n• વાઇન્ડિંગ ટેસ્ટ નિયમ: R(Start-Run) = R(Common-Start) + R(Common-Run)\n• ઝડપ અને ફ્રિક્વન્સી: N_s = (120 × f) / P  (RPM)",
        equationsHi =
          "• कैपेसिटिव रिएक्टेंस: X_c = 1 / (2 × π × f × C)  (50Hz, 2.5µF के लिए ≈ 1273 Ω)\n• वाइंडिंग परीक्षण सूत्र: R(Start-Run) = R(Common-Start) + R(Common-Run)\n• सिंक्रोनस गति: N_s = (120 × f) / P  (RPM)",
        equationsEn =
          "• Capacitive Reactance: X_c = 1 / (2 × π × f × C)  [≈ 1273 Ω for 2.5 µF at 50 Hz]\n• 3-Wire Winding Sum: R(Start–Run) = R(Common–Start) + R(Common–Run)\n• Synchronous Speed: N_s = (120 × f) / P  (RPM)",
        impQuestionsGu =
          "Q: સિલિંગ ફેનમાં 2.5 µF કેપેસિટરનું કામ શું છે?\nA: સિંગલ-ફેઝ મોટર જાતે શરૂ થઈ શકતી નથી; કેપેસિટર 90° ફેઝ-શિફ્ટ બનાવી સ્ટાર્ટિંગ ટોર્ક ઉત્પન્ન કરે છે.\n---\nQ: મોટરના 3 વાયરમાંથી Common વાયર મલ્ટિમીટરથી કેવી રીતે શોધવો?\nA: જે બે વાયર વચ્ચે સૌથી વધુ અવરોધ (દા.ત. 380 Ω) મળે, તેની સામેનો ત્રીજો વાયર Common છે.\n---\nQ: પંખામાંથી ઘર્ષણનો અવાજ કેમ આવે છે?\nA: 6201 અને 6202 નંબરના બોલ બેરિંગ સૂકાઈ જવાથી કે તૂટવાથી.",
        impQuestionsHi =
          "Q: सीलिंग फैन में 2.5 µF कैपेसिटर क्यों लगाया जाता है?\nA: सिंगल-फेज मोटर को सेल्फ-स्टार्ट करने हेतु दो वाइंडिंग में फेज अंतर (Starting Torque) बनाने के लिए।\n---\nQ: 3 तारों में से कॉमन वायर की पहचान कैसे करें?\nA: जिन दो तारों के बीच सबसे अधिक रेजिस्टेंस आए, बचा हुआ तीसरा तार कॉमन (Common) होता है।\n---\nQ: पुराने रेजिस्टेंस रेगुलेटर की तुलना में इलेक्ट्रॉनिक (Triac) रेगुलेटर बेहतर क्यों है?\nA: इलेक्ट्रॉनिक रेगुलेटर में कम स्पीड पर बिजली की बर्बादी और गर्मी बहुत कम होती है।",
        impQuestionsEn =
          "Q: Why can't a single-phase ceiling fan start without its capacitor?\nA: A single phase creates a pulsating field only; the capacitor shifts starting coil phase to create rotating torque.\n---\nQ: How do you identify the Common wire among 3 fan leads using a DMM?\nA: Measure all 3 pairs; the two leads showing the highest resistance are Start & Run, so the remaining 3rd wire is Common.\n---\nQ: Why replace old resistive regulators with Triac electronic regulators?\nA: Triac regulators save electricity at low speeds instead of wasting power as heat.",
        rememberTipGu = "વધુ પડતા મૂલ્યનો (દા.ત. 4 µF) કેપેસિટર ક્યારેય ન લગાવો — મોટર વાઇન્ડિંગ વધુ ગરમ થઈ બળી જશે!",
        rememberTipHi = "2.5 µF की जगह बहुत बड़ा (जैसे 4 µF) कैपेसिटर न लगाएं, वरना वाइंडिंग गर्म होकर जल सकती है।",
        rememberTipEn = "Never oversize a fan capacitor (e.g., 4 µF instead of 2.5 µF); excess current overheats stator windings.",
        glossaryGu = "સ્ટાર્ટિંગ વાઇન્ડિંગ: વધુ અવરોધ વાળી કોઇલ • રોટર: ફરતો બાહ્ય ભાગ • બેરિંગ 6201/6202",
        glossaryHi = "स्टार्टिंग वाइंडिंग: अधिक प्रतिरोध वाली कॉइल • रोटर: घूमने वाला भाग • बेयरिंग 6201/6202",
        glossaryEn = "Stator: Stationary coil core • Phase Shift: 90° lag/lead for torque • Cotter Pin: Locking safety pin",
        circuitDiagramId = "circuit_ceiling_fan",
        linkedPracticalId = "prac_10_3",
        estimatedMinutes = 14,
        downloadSizeKb = 670,
        isDownloadedOffline = true,
        sortOrder = 5,
      ),

      LessonEntity(
        lessonId = "lesson_10_3",
        classStd = 10,
        chapterCode = "Std 10 • Module 3 & Project",
        tradeNameGu = TRADE_9_10_GU,
        tradeNameHi = TRADE_9_10_HI,
        tradeNameEn = TRADE_9_10_EN,
        unitTitleGu = "એર કૂલર ઇન્સ્ટોલેશન, રિપેર અને મેન્યુફેક્ચરિંગ પ્રોજેક્ટ",
        unitTitleHi = "एयर कूलर स्थापना, मरम्मत एवं निर्माण प्रोजेक्ट",
        unitTitleEn = "Installation, Repair & Manufacturing of Air Cooler",
        titleGu = "મોડ્યુલ 3 + પ્રોજેક્ટ: એર કૂલર વાયરિંગ, પંપ રિપેર અને ગ્રીન પ્રેક્ટિસ",
        titleHi = "मॉड्यूल 3 + प्रोजेक्ट: एयर कूलर वायरिंग, वॉटर पंप और हरित रखरखाव",
        titleEn = "Module 3 & Project: Air Cooler Wiring, Pump & Maintenance",
        summaryGu = "બાષ્પીભવન કૂલિંગ સિદ્ધાંત, 3-સ્પીડ ફેન સ્વિચ, સબમર્સિબલ વોટર પંપ અને એર કૂલર એસેમ્બલી પ્રોજેક્ટ.",
        summaryHi = "वाष्पीकरण कूलिंग सिद्धांत, 3-स्पीड फैन स्विच, सबमर्सिबल पंप और एयर कूलर निर्माण प्रोजेक्ट।",
        summaryEn = "Evaporative cooling, dual-switch motor/pump wiring, pump cleaning, green maintenance, and cooler assembly project.",
        learningOutcomesGu =
          "• હનીકોમ્બ/વૂડ-વૂલ પેડ અને પાણીના વિતરણ દ્વારા ઠંડકની પ્રક્રિયા સમજવી.\n• 3-સ્પીડ રોટરી સ્વિચ, સ્વિંગ મોટર અને 18W વોટર પંપનું વાયરિંગ કરવું.\n• પાણી બચાવ, ડેન્ગ્યુ નિવારણ અને ગ્રીન રિસાયક્લિંગ પ્રેક્ટિસ અપનાવવી.",
        learningOutcomesHi =
          "• वाष्पीकरण द्वारा शीतलन प्रक्रिया और हनीकॉम्ब पैड की देखभाल समझना।\n• 3-स्पीड फैन स्विच, स्विंग मोटर और वॉटर पंप की वायरिंग करना।\n• जल संरक्षण और एयर कूलर असेंबली प्रोजेक्ट पूरा करना।",
        learningOutcomesEn =
          "• Explain evaporative cooling and proper placement near cross-ventilation.\n• Wire the 3-speed rotary fan switch, swing motor, and submersible pump safely.\n• Execute preventive green cleaning and assemble a mini air cooler project.",
        bodyGu =
          "📌 સેશન 1 — એર કૂલર ઇન્સ્ટોલેશન: કૂલર હંમેશા બારી પાસે મૂકો જેથી તાજી હવા મળે (બંધ રૂમમાં ભેજ વધે છે). અંદર ફેન મોટર (M1) અને સબમર્સિબલ વોટર પંપ (P1) સમાંતર જોડાયેલા હોય છે.\n\n📌 સેશન 2 — ગ્રીન પ્રેક્ટિસ: દર અઠવાડિયે ટાંકી સાફ કરી પાણી બદલો (મચ્છર ઉત્પત્તિ અટકાવવા), હનીકોમ્બ પેડ્સ ધોઈને ફરી વાપરો.\n\n📌 પ્રોજેક્ટ — એર કૂલર મેન્યુફેક્ચરિંગ: કેબિનેટ/ફ્રેમ ફિટિંગ, ફેન મોટર માઉન્ટિંગ, ટાંકીમાં પંપ અને સ્પ્લિટર પાઇપ, ઇલેક્ટ્રિકલ કંટ્રોલ પેનલ વાયરિંગ અને ફાઇનલ લીકેજ ટેસ્ટ.",
        bodyHi =
          "📌 सत्र 1 — एयर कूलर इंस्टॉलेशन: कूलर को खुली खिड़की के पास रखें ताकि ताजी हवा मिले। इसमें ब्लोअर मोटर (M1) और पंप (P1) पैरेलल में अलग स्विच से चलते हैं।\n\n📌 सत्र 2 — हरित अभ्यास: पानी की बर्बादी रोकें, साप्ताहिक टैंक साफ करें और पुराने कूलर पैड/प्लास्टिक का सही पुनर्चक्रण करें।\n\n📌 प्रोजेक्ट — एयर कूलर निर्माण: बॉडी असेंबली, मोटर माउंटिंग, पंप-पाइप फिटिंग, 3-स्पीड स्विच वायरिंग और अर्थ लीकेज जांच।",
        bodyEn =
          "📌 Session 1 — Installation: Place cooler near an open window for fresh airflow. Inside, 3-speed blower motor (M1) and submersible pump (P1) run in parallel via separate switches.\n\n📌 Session 2 — Waste & Green Practices: Drain/clean tanks weekly to conserve water and prevent breeding; recycle old PVC pads and plastic housings.\n\n📌 Project — Air Cooler Manufacturing: Frame assembly, blower alignment, water distribution tray/pump piping, rotary panel wiring, and earth safety verification.",
        equationsGu =
          "• કુલ કૂલર પાવર: P_total = P_fan + P_pump + P_swing  (દા.ત. 150W + 18W + 5W = 173W)\n• માસિક વીજ બિલ (8 કલાક/દિવસ): Units = (173W × 8 × 30) / 1000 = 41.5 kWh\n• એર ડિલિવરી રૂપાંતરણ: 1 CMM ≈ 35.3 CFM",
        equationsHi =
          "• कुल कूलर पावर: P_total = P_fan + P_pump + P_swing  (उदा. 150W + 18W + 5W = 173W)\n• मासिक खपत (8 घंटे/दिन): Units = (173W × 8 × 30) / 1000 = 41.5 kWh\n• एयर फ्लो रूपांतरण: 1 CMM ≈ 35.3 CFM",
        equationsEn =
          "• Total Cooler Load: P_total = P_fan + P_pump + P_swing  [e.g., 150W + 18W + 5W = 173W]\n• Monthly Energy (8 hr/day): kWh = (173 × 8 × 30) / 1000 = 41.52 Units\n• Airflow Conversion: 1 CMM (m³/min) ≈ 35.31 CFM",
        impQuestionsGu =
          "Q: એર કૂલર કયા સિદ્ધાંત પર ઠંડક આપે છે?\nA: બાષ્પીભવન કૂલિંગ (Evaporative Cooling) — ગરમ હવા ભીના પેડ પરથી પસાર થતાં પાણીની વરાળ બને છે અને હવા ઠંડી થાય છે.\n---\nQ: મેટલ બોડી વાળા કૂલરમાં અર્થિંગ કેમ અત્યંત જરૂરી છે?\nA: કારણ કે પાણી અને 230V AC મોટર-પંપ સાથે હોય છે; તૂટેલો વાયર આખી બોડીમાં શોક ફેલાવી શકે છે.\n---\nQ: પાણીનો પંપ ચાલુ કરવા છતાં પાણી ઉપર ન ચઢતું હોય તો શું તપાસશો?\nA: પંપનું ઇમ્પેલર જામ હોવું, ઇનલેટ ફિલ્ટર કચરાથી બંધ થવું અથવા 230V પંપ સ્વિચ SW2 તપાસવી.",
        impQuestionsHi =
          "Q: एयर कूलर किस सिद्धांत पर ठंडक देता है?\nA: वाष्पीकरण शीतलन (Evaporative Cooling) के सिद्धांत पर।\n---\nQ: यदि कूलर का पंप आवाज़ कर रहा है पर पानी ऊपर नहीं आ रहा, तो क्या कारण हो सकते हैं?\nA: टंकी में पानी कम होना, पंप का इम्पेलर जाम होना या पाइप में हवा/कचरा फंसना।\n---\nQ: कूलर को बंद कमरे में चलाने पर चिपचिपाहट क्यों लगती है?\nA: बंद कमरे में नमी (Humidity) बढ़ जाती है; इसलिए क्रॉस-वेंटिलेशन जरूरी है।",
        impQuestionsEn =
          "Q: Why should an air cooler never be operated in a completely sealed room?\nA: Evaporative cooling raises indoor humidity; fresh air intake and cross-ventilation are required.\n---\nQ: What should you check if the cooler pump hums but pumps no water?\nA: Low tank water level, clogged intake mesh, jammed magnetic impeller, or kinked delivery tube.\n---\nQ: Why is the pump wired independently from the fan switch?\nA: So users can run dry-fan mode during humid weather or switch off the pump when the tank is empty.",
        rememberTipGu = "ટાન્કીમાં પાણી ભરતી વખતે હંમેશા કૂલરનો પ્લગ સોકેટમાંથી કાઢીને જ પાણી ભરો!",
        rememberTipHi = "कूलर में पानी भरते समय हमेशा मेन प्लग निकालकर ही पानी डालें!",
        rememberTipEn = "Always unplug the cooler from the wall socket before refilling the water tank or cleaning pads.",
        glossaryGu = "સબમર્સિબલ પંપ: પાણીમાં ડૂબેલો પંપ • હનીકોમ્બ પેડ: બાષ્પીભવન પેડ • ઇમ્પેલર: પંપનું પંખું",
        glossaryHi = "सबमर्सिबल पंप: पानी में डूबा पंप • हनीकॉम्ब पैड: कूलिंग पैड • इम्पेलर: पंप रोटर",
        glossaryEn = "Evaporative Cooling: Heat absorbed by water evaporation • Impeller: Rotating pump vane • Float Valve",
        circuitDiagramId = "circuit_air_cooler",
        linkedPracticalId = "prac_10_4",
        estimatedMinutes = 14,
        downloadSizeKb = 660,
        isDownloadedOffline = true,
        sortOrder = 6,
      ),
    )

  val practicals: List<PracticalEntity> =
    listOf(
      PracticalEntity(
        practicalId = "prac_9_1",
        classStd = 9,
        practicalCode = "PRAC-9.1 (Mod 1)",
        linkedLessonId = "lesson_9_1",
        circuitDiagramId = "circuit_led_series",
        titleGu = "પ્રયોગ 9.1: ઓહ્મનો નિયમ, સિરીઝ-પેરેલલ સર્કિટ અને મલ્ટિમીટર માપન",
        titleHi = "प्रयोग 9.1: ओम का नियम, सीरीज़-पैरेलल सर्किट और मल्टीमीटर मापन",
        titleEn = "Practical 9.1: Ohm's Law, LED Series Circuit & DMM Testing",
        aimGu = "330Ω રેઝિસ્ટર કલર કોડ ચકાસી 9V બેટરી વડે LED સર્કિટ બનાવી વોલ્ટેજ અને કરંટ માપવો.",
        aimHi = "330Ω रेजिस्टर कलर कोड जांचकर 9V बैटरी से LED सर्किट बनाना और वोल्टेज व करंट मापना।",
        aimEn = "Verify 330Ω resistor via DMM, build the 9V LED series loop on breadboard, and measure V_LED and I.",
        toolsGu = "બ્રેડબોર્ડ, 9V બેટરી, 330Ω રેઝિસ્ટર, લાલ LED, SPST સ્વિચ, જમ્પર વાયર, DMM",
        toolsHi = "ब्रेडबोर्ड, 9V बैटरी, 330Ω रेजिस्टर, लाल LED, SPST स्विच, जम्पर वायर, DMM",
        toolsEn = "Breadboard, 9V Battery, 330Ω Resistor, Red LED, SPST Switch, Jumpers, Digital Multimeter",
        safetyWarningGu = "રેઝિસ્ટર R1 લગાવ્યા વિના LED સીધી 9V બેટરી સાથે ન જોડો; બેટરી ટર્મિનલ શોર્ટ ન કરો.",
        safetyWarningHi = "बिना रेजिस्टर R1 के LED को सीधे 9V बैटरी से न जोड़ें; टर्मिनल शॉर्ट न करें।",
        safetyWarningEn = "Never connect LED to 9V without series resistor R1; keep battery clip detached while wiring.",
        theoryShortGu = "I = (V_s - V_f) / R1 = (9V - 2V) / 330Ω ≈ 21.2 mA, જે LED માટે સંપૂર્ણ સુરક્ષિત છે.",
        theoryShortHi = "I = (V_s - V_f) / R1 = (9V - 2V) / 330Ω ≈ 21.2 mA, जो LED के लिए सुरक्षित है।",
        theoryShortEn = "Series current I = (9V - 2V) / 330Ω ≈ 21.2 mA stays safely within LED limits.",
        badgeLabel = "Mod 1 • Circuits Lab",
        isDownloadedOffline = true,
        sortOrder = 1,
      ),
      PracticalEntity(
        practicalId = "prac_9_2",
        classStd = 9,
        practicalCode = "PRAC-9.2 (Mod 1)",
        linkedLessonId = "lesson_9_1",
        circuitDiagramId = "circuit_led_series",
        titleGu = "પ્રયોગ 9.2: ઇલેક્ટ્રોનિક ઘટકોની ઓળખ, પોલેરિટી અને સુરક્ષિત સોલ્ડરિંગ",
        titleHi = "प्रयोग 9.2: इलेक्ट्रॉनिक घटकों की पहचान, ध्रुवता और सुरक्षित सोल्डरिंग",
        titleEn = "Practical 9.2: Component Identification, Polarity & Soldering",
        aimGu = "રેઝિસ્ટર, કેપેસિટર, ડાયોડ, LED અને ટ્રાન્ઝિસ્ટરની પિન્સ ઓળખી વેરોબોર્ડ પર સોલ્ડરિંગ કરવું.",
        aimHi = "रेजिस्टर, कैपेसिटर, डायोड, LED व ट्रांजिस्टर की पिन पहचानकर वेरोबोर्ड पर सोल्डरिंग करना।",
        aimEn = "Identify passive & semiconductor leads, solder LED+R1 cleanly on veroboard, and test continuity.",
        toolsGu = "25W સોલ્ડરિંગ આયર્ન અને સ્ટેન્ડ, સોલ્ડર વાયર, વેરોબોર્ડ, વિવિધ ઘટકો, મલ્ટિમીટર, સેફ્ટી ચશ્માં",
        toolsHi = "25W सोल्डरिंग आयरन व स्टैंड, सोल्डर वायर, वेरोबोर्ड, विभिन्न घटक, मल्टीमीटर, सुरक्षा चश्मा",
        toolsEn = "25W Soldering Iron & Stand, Solder Wire, Veroboard, Electronic Components, DMM, Safety Glasses",
        safetyWarningGu = "સોલ્ડરિંગ ટીપ ~350°C ગરમ હોય છે — સ્ટેન્ડમાં રાખો અને ચશ્માં પહેરો.",
        safetyWarningHi = "सोल्डरिंग टिप ~350°C गर्म होती है — स्टैंड में रखें और सुरक्षा चश्मा पहनें।",
        safetyWarningEn = "HOT IRON (350°C): Always use stand, safety glasses, and ventilated workspace.",
        theoryShortGu = "ડાયોડમાં સિલ્વર પટ્ટી Cathode (-) છે; સારો સોલ્ડર જોઇન્ટ ચમકદાર અને શંકુ આકારનો હોય છે.",
        theoryShortHi = "डायोड पर सिल्वर बैंड Cathode (-) है; अच्छा सोल्डर जॉइंट चमकदार व शंकु आकार का होता है।",
        theoryShortEn = "Silver band marks Diode Cathode (-); proper solder fillets are shiny and smooth.",
        badgeLabel = "Soldering Level 1",
        isDownloadedOffline = true,
        sortOrder = 2,
      ),
      PracticalEntity(
        practicalId = "prac_9_3",
        classStd = 9,
        practicalCode = "PRAC-9.3 (Mod 2)",
        linkedLessonId = "lesson_9_2",
        circuitDiagramId = "circuit_led_bulb_driver",
        titleGu = "પ્રયોગ 9.3: 9W LED બલ્બ ડ્રાઇવર ફોલ્ટ નિદાન અને MCPCB રિપેર",
        titleHi = "प्रयोग 9.3: 9W LED बल्ब ड्राइवर फॉल्ट जांच और MCPCB रिपेयर",
        titleEn = "Practical 9.3: 9W LED Bulb Disassembly & Driver Repair",
        aimGu = "સીરીઝ ટેસ્ટ લેમ્પ અને DMM વડે ડેડ LED બલ્બમાંથી ફ્યુઝ F1, બ્રિજ BR1, C1 અને MCPCB તપાસવું.",
        aimHi = "सीरीज़ टेस्ट लैंप और DMM से डेड LED बल्ब में फ्यूज़ F1, ब्रिज BR1, C1 और MCPCB की जांच करना।",
        aimEn = "Safely inspect a dead 9W LED bulb via Series Test Lamp & DMM, isolate F1/C1/MCPCB fault, and repair.",
        toolsGu = "સીરીઝ ટેસ્ટ લેમ્પ બોર્ડ, 9W LED બલ્બ, મલ્ટિમીટર, સોલ્ડરિંગ આયર્ન, થર્મલ પેસ્ટ, પ્લાસ્ટિક ઓપનર",
        toolsHi = "सीरीज़ टेस्ट लैंप बोर्ड, 9W LED बल्ब, मल्टीमीटर, सोल्डरिंग आयरन, थर्मल पेस्ट, ओपनर",
        toolsEn = "Series Test Lamp Board, 9W LED Bulb, Digital Multimeter, Soldering Iron, Thermal Paste, Opener",
        safetyWarningGu = "ચેતવણી: બલ્બ સીધો 230V મેઇન્સમાં ન લગાવો — હંમેશા સીરીઝ ટેસ્ટ લેમ્પથી તપાસો અને C1 ડિસ્ચાર્જ કરો.",
        safetyWarningHi = "चेतावनी: बल्ब को सीधे 230V में न लगाएं — हमेशा सीरीज़ टेस्ट लैंप से जांचें व C1 डिस्चार्ज करें।",
        safetyWarningEn = "230V MAINS HAZARD: Test exclusively through a Series Test Lamp and discharge C1 first.",
        theoryShortGu = "મોટાભાગના બલ્બમાં ફક્ત ફ્યુઝિબલ રેઝિસ્ટર F1 અથવા 1–2 SMD LED બળવાથી બલ્બ બંધ થાય છે.",
        theoryShortHi = "अधिकांश LED बल्ब में फ्यूज़िबल रेजिस्टर F1 या कोई एक SMD LED खराब होने से बल्ब बंद होता है।",
        theoryShortEn = "Most dead bulbs stem from an open F1 fusible resistor, dried C1, or one open SMD chip on MCPCB.",
        badgeLabel = "LED Technician",
        isDownloadedOffline = true,
        sortOrder = 3,
      ),
      PracticalEntity(
        practicalId = "prac_9_4",
        classStd = 9,
        practicalCode = "PRAC-9.4 (Mod 3)",
        linkedLessonId = "lesson_9_3",
        circuitDiagramId = null,
        titleGu = "પ્રયોગ 9.4: વર્કશોપ PPE તપાસ, ફાયર ક્લાસ અને E-વેસ્ટ વર્ગીકરણ ડ્રિલ",
        titleHi = "प्रयोग 9.4: कार्यशाला PPE जांच, फायर क्लास और ई-कचरा वर्गीकरण ड्रिल",
        titleEn = "Practical 9.4: Workshop PPE, Fire Safety & E-Waste Drill",
        aimGu = "લાઇવ પેનલ કામ પહેલાં PPE તપાસવી, CO₂ અગ્નિશામક PASS પ્રક્રિયા શીખવી અને E-વેસ્ટ અલગ પાડવો.",
        aimHi = "कार्य से पहले PPE जांचना, CO₂ एक्सटिंग्विशर PASS विधि सीखना और ई-कचरा अलग करना।",
        aimEn = "Perform pre-work PPE & RCCB trip audit, demonstrate PASS extinguisher steps, and sort lab e-waste.",
        toolsGu = "ઇન્સ્યુલેટેડ ગ્લોવ્ઝ, રબર મેટ, સેફ્ટી ચશ્માં, ડમી CO₂ અગ્નિશામક, 3-રંગના વેસ્ટ બિન",
        toolsHi = "इंसुलेटेड दस्ताने, रबर मैट, सुरक्षा चश्मा, CO₂ एक्सटिंग्विशर, 3-रंग के कचरा बिन",
        toolsEn = "Insulated Gloves, Rubber Mat, Safety Glasses, CO2 Extinguisher, 3-Color Waste Segregation Bins",
        safetyWarningGu = "મોક ડ્રિલ શિક્ષકની હાજરીમાં જ કરો; અસલી પાવર ચાલુ હોય ત્યારે અગ્નિશામક પિન ન ખેંચો.",
        safetyWarningHi = "मॉक ड्रिल शिक्षक की उपस्थिति में करें; अनावश्यक रूप से फायर एक्सटिंग्विशर पिन न निकालें।",
        safetyWarningEn = "Conduct PASS drill under instructor supervision; verify rubber insulation before touching panels.",
        theoryShortGu = "સુરક્ષિત વર્કશોપ = 0 અકસ્માત + 100% E-વેસ્ટ રિસાયક્લિંગ.",
        theoryShortHi = "सुरक्षित कार्यशाला = शून्य दुर्घटना + 100% ई-कचरा प्रबंधन।",
        theoryShortEn = "Zero-accident lab habits combine PPE compliance, RCCB testing, and hazardous e-waste segregation.",
        badgeLabel = "Safety Guardian",
        isDownloadedOffline = true,
        sortOrder = 4,
      ),

      // ==================== GRADE X PRACTICALS ====================
      PracticalEntity(
        practicalId = "prac_10_1",
        classStd = 10,
        practicalCode = "PRAC-10.1 (Mod 1)",
        linkedLessonId = "lesson_10_1",
        circuitDiagramId = "circuit_electric_iron",
        titleGu = "પ્રયોગ 10.1: ઇલેક્ટ્રિક આયર્ન કન્ટિન્યુઇટી, અર્થ લીકેજ અને થર્મોસ્ટેટ ટેસ્ટ",
        titleHi = "प्रयोग 10.1: इलेक्ट्रिक आयरन कंटिन्यूटी, अर्थ लीकेज और थर्मोस्टेट परीक्षण",
        titleEn = "Practical 10.1: Electric Iron Continuity, Earth & Thermostat Test",
        aimGu = "મલ્ટિમીટરથી આયર્નના કોર્ડ, અર્થ પિન, થર્મોસ્ટેટ કટ-ઓફ અને હીટિંગ એલિમેન્ટનો અવરોધ માપવો.",
        aimHi = "मल्टीमीटर से आयरन कॉर्ड, अर्थ पिन, थर्मोस्टेट कट-ऑफ और हीटिंग एलिमेंट का प्रतिरोध मापना।",
        aimEn = "Verify cord continuity, protective earth (<1Ω), soleplate insulation (OL), and thermostat switching.",
        toolsGu = "ઇલેક્ટ્રિક આયર્ન, ડિજિટલ મલ્ટિમીટર, સીરીઝ ટેસ્ટ લેમ્પ, ઇન્સ્યુલેટેડ સ્ક્રુડ્રાઇવર",
        toolsHi = "इलेक्ट्रिक आयरन, डिजिटल मल्टीमीटर, सीरीज़ टेस्ट लैंप, इंसुलेटेड स्क्रूड्राइवर",
        toolsEn = "Electric Iron, Digital Multimeter, Series Test Lamp, Insulated Screwdriver Set",
        safetyWarningGu = "સોલપ્લેટ અત્યંત ગરમ થઈ શકે છે! અવરોધ માપતી વખતે પ્લગ સોકેટમાંથી બહાર કાઢો.",
        safetyWarningHi = "सोलप्लेट अत्यधिक गर्म हो सकती है! रेजिस्टेंस मापते समय प्लग हमेशा निकाल कर रखें।",
        safetyWarningEn = "BURN & SHOCK RISK: Unplug iron completely before DMM resistance tests; let soleplate cool.",
        theoryShortGu = "સારી 1000W ઇસ્ત્રીમાં L–N વચ્ચે ~53Ω, E–બોડી વચ્ચે <1Ω અને L/N–બોડી વચ્ચે OL હોવું જોઈએ.",
        theoryShortHi = "स्वस्थ 1000W आयरन में L–N ~53Ω, E–बॉडी <1Ω और L/N–बॉडी OL (अनंत) होना चाहिए।",
        theoryShortEn = "Healthy 1000W iron reads ~53Ω across L-N, <1Ω Earth-to-Body, and OL (infinite) Line-to-Body.",
        badgeLabel = "Appliance Tester",
        isDownloadedOffline = true,
        sortOrder = 5,
      ),
      PracticalEntity(
        practicalId = "prac_10_2",
        classStd = 10,
        practicalCode = "PRAC-10.2 (Mod 1)",
        linkedLessonId = "lesson_10_1",
        circuitDiagramId = "circuit_electric_iron",
        titleGu = "પ્રયોગ 10.2: ખરાબ આયર્નમાં થર્મલ ફ્યુઝ બદલવો અને થર્મોસ્ટેટ સાફ કરવો",
        titleHi = "प्रयोग 10.2: खराब आयरन में थर्मल फ्यूज़ बदलना और थर्मोस्टेट साफ करना",
        titleEn = "Practical 10.2: Thermal Fuse Replacement & Thermostat Calibration",
        aimGu = "ડેડ આયર્ન ખોલીને બળેલો 240°C થર્મલ ફ્યુઝ ક્રિમ્પિંગ સ્લીવથી બદલવો અને થર્મોસ્ટેટ પોઇન્ટ સાફ કરવા.",
        aimHi = "डेड आयरन खोलकर खराब 240°C थर्मल फ्यूज़ बदलना और थर्मोस्टेट कॉन्टैक्ट साफ करना।",
        aimEn = "Disassemble iron housing, replace blown 240°C thermal fuse using crimp sleeves, and clean contacts.",
        toolsGu = "240°C/10A થર્મલ ફ્યુઝ, ક્રિમ્પિંગ પ્લાયર, ફાઇન સેન્ડપેપર, સ્ક્રુડ્રાઇવર સેટ, DMM",
        toolsHi = "240°C/10A थर्मल फ्यूज़, क्रिम्पिंग प्लायर, बारीक सैंडपेपर, स्क्रूड्राइवर सेट, DMM",
        toolsEn = "240°C/10A Thermal Fuse, Crimp Sleeves & Pliers, Fine Sandpaper, Screwdriver Set, DMM",
        safetyWarningGu = "થર્મલ ફ્યુઝને ક્યારેય સોલ્ડરિંગ આયર્નથી સીધો સોલ્ડર ન કરો (ગરમીથી નવો ફ્યુઝ ઊડી જશે) — ક્રિમ્પ કરો!",
        safetyWarningHi = "थर्मल फ्यूज़ को सीधे सोल्डर न करें (गर्मी से फ्यूज़ टूट जाएगा) — केवल क्रिम्प स्लीव का उपयोग करें!",
        safetyWarningEn = "Never solder a thermal fuse directly (heat blows it); always use mechanical crimp sleeves!",
        theoryShortGu = "ક્રિમ્પ કનેક્શન ગરમીમાં ઢીલું પડતું નથી અને નવા થર્મલ ફ્યુઝને સુરક્ષિત રાખે છે.",
        theoryShortHi = "क्रिम्पिंग जोड़ उच्च तापमान में ढीला नहीं होता और नए थर्मल फ्यूज़ को सुरक्षित रखता है।",
        theoryShortEn = "Crimp sleeves withstand soleplate heat and protect the 240°C fuse element during assembly.",
        badgeLabel = "Iron Repair Pro",
        isDownloadedOffline = true,
        sortOrder = 6,
      ),
      PracticalEntity(
        practicalId = "prac_10_3",
        classStd = 10,
        practicalCode = "PRAC-10.3 (Mod 2)",
        linkedLessonId = "lesson_10_2",
        circuitDiagramId = "circuit_ceiling_fan",
        titleGu = "પ્રયોગ 10.3: સિલિંગ ફેન 2.5µF કેપેસિટર ટેસ્ટ, વાઇન્ડિંગ ઓળખ અને રેગ્યુલેટર",
        titleHi = "प्रयोग 10.3: सीलिंग फैन 2.5µF कैपेसिटर जांच, वाइंडिंग पहचान और रेगुलेटर",
        titleEn = "Practical 10.3: Fan 2.5µF Capacitor, Winding & Regulator Wiring",
        aimGu = "સિલિંગ ફેનના 3 વાયરમાંથી Common/Start/Run ઓળખવા, 2.5µF કેપેસિટર તપાસવો અને રેગ્યુલેટર જોડવો.",
        aimHi = "सीलिंग फैन के 3 तारों में Common/Start/Run पहचानना, 2.5µF कैपेसिटर जांचना और रेगुलेटर जोड़ना।",
        aimEn = "Identify 3 stator leads via DMM, test 2.5µF capacitor health, and wire Triac speed regulator.",
        toolsGu = "સિલિંગ ફેન સ્ટેટર/યુનિટ, 2.5µF/440V કેપેસિટર, ટ્રાયક રેગ્યુલેટર, DMM, ઇન્સ્યુલેટેડ પ્લાયર",
        toolsHi = "सीलिंग फैन यूनिट, 2.5µF/440V कैपेसिटर, ट्रायक रेगुलेटर, DMM, इंसुलेटेड प्लायर",
        toolsEn = "Ceiling Fan Stator/Unit, 2.5µF/440V Capacitor, Triac Fan Regulator, DMM, Insulated Pliers",
        safetyWarningGu = "2.5µF કેપેસિટર ટેસ્ટ કરતા પહેલાં તેના બંને છેડા ઇન્સ્યુલેટેડ સ્ક્રુડ્રાઇવરથી ડિસ્ચાર્જ કરો.",
        safetyWarningHi = "2.5µF कैपेसिटर की जांच से पहले दोनों पिन को इंसुलेटेड स्क्रूड्राइवर से शॉर्ट कर डिस्चार्ज करें।",
        safetyWarningEn = "Discharge the 440V fan capacitor safely before probing; switch off MCB before wiring.",
        theoryShortGu = "સૌથી વધુ Ω આપતા 2 વાયર Start અને Run છે; ત્રીજો Common છે. R(C–Start) > R(C–Run).",
        theoryShortHi = "सबसे अधिक प्रतिरोध वाले 2 तार Start और Run होते हैं; तीसरा Common है। R(C–Start) > R(C–Run)।",
        theoryShortEn = "Highest resistance pair = Start + Run; third wire = Common. Starting coil > Running coil ohms.",
        badgeLabel = "Fan Motor Tech",
        isDownloadedOffline = true,
        sortOrder = 7,
      ),
      PracticalEntity(
        practicalId = "prac_10_4",
        classStd = 10,
        practicalCode = "PRAC-10.4 (Mod 3)",
        linkedLessonId = "lesson_10_3",
        circuitDiagramId = "circuit_air_cooler",
        titleGu = "પ્રયોગ 10.4: એર કૂલર સબમર્સિબલ પંપ ટેસ્ટ અને 3-સ્પીડ સ્વિચ વાયરિંગ",
        titleHi = "प्रयोग 10.4: एयर कूलर सबमर्सिबल पंप जांच और 3-स्पीड स्विच वायरिंग",
        titleEn = "Practical 10.4: Air Cooler Submersible Pump & 3-Speed Wiring",
        aimGu = "એર કૂલરના 3-સ્પીડ રોટરી સ્વિચ, 18W વોટર પંપ અને અર્થિંગનું વાયરિંગ તપાસીને ચાલુ કરવું.",
        aimHi = "एयर कूलर के 3-स्पीड रोटरी स्विच, 18W वॉटर पंप और अर्थिंग की वायरिंग कर संचालन जांचना।",
        aimEn = "Test 3-speed blower switch, inspect 18W pump & impeller, and verify leak-free cooler operation.",
        toolsGu = "એર કૂલર ડેમો કિટ/યુનિટ, 3-સ્પીડ સ્વિચ, 18W પંપ, DMM, ટેસ્ટર, ડોલ પાણી",
        toolsHi = "एयर कूलर यूनिट, 3-स्पीड स्विच, 18W पंप, DMM, टेस्टर, पानी की बाल्टी",
        toolsEn = "Air Cooler Unit, 3-Speed Rotary Switch, 18W Submersible Pump, DMM, Line Tester, Water Bucket",
        safetyWarningGu = "પાણી અને 230V AC નજીક હોવાથી કૂલર ચાલુ હોય ત્યારે પાણીમાં હાથ ન નાખો; અર્થિંગ ચકાસો.",
        safetyWarningHi = "पानी और 230V AC पास होने के कारण चलते कूलर के पानी में हाथ न डालें; अर्थिंग जांचें।",
        safetyWarningEn = "WATER + 230V HAZARD: Never touch tank water while plugged in; verify body earth first.",
        theoryShortGu = "પંપ હંમેશા પાણીમાં ડૂબેલો રહેવો જોઈએ અને ફેન તથા પંપ સ્વિચ સમાંતર જોડાય છે.",
        theoryShortHi = "पंप हमेशा पानी में डूबा रहना चाहिए तथा फैन और पंप के स्विच पैरेलल जुड़े होते हैं।",
        theoryShortEn = "Submersible pump runs submerged only; blower and pump branches operate in parallel.",
        badgeLabel = "Cooler Project Lead",
        isDownloadedOffline = true,
        sortOrder = 8,
      ),
    )

  val practicalSteps: List<PracticalStepEntity> =
    listOf(
      // --- Prac 9.1 ---
      PracticalStepEntity("s_9_1_1", "prac_9_1", 1, true, "સુરક્ષા: 9V બેટરી ક્લિપ હમણાં અલગ રાખો અને બ્રેડબોર્ડની સપાટી સુકી છે તેની ખાતરી કરો.", "सुरक्षा: 9V बैटरी क्लिप अलग रखें और ब्रेडबोर्ड सूखा होने की पुष्टि करें।", "Safety Check: Keep 9V battery detached while inserting components on breadboard.", "બેટરી અલગ છે", "बैटरी अलग है", "Battery detached", "B1"),
      PracticalStepEntity("s_9_1_2", "prac_9_1", 2, true, "સુરક્ષા: DMM થી R1 (330Ω) નો અવરોધ માપી ખાતરી કરો (290–360Ω) જેથી LED બળે નહીં.", "सुरक्षा: DMM से R1 (330Ω) का प्रतिरोध जांचें ताकि LED सुरक्षित रहे।", "Safety Check: Verify R1 ≈ 330Ω with DMM before wiring LED.", "R1 ≈ 330 Ω", "R1 ≈ 330 Ω", "R1 ≈ 330 Ω", "R1"),
      PracticalStepEntity("s_9_1_3", "prac_9_1", 3, false, "બ્રેડબોર્ડ પર SW1 અને R1 ને શ્રેણીમાં જોડો અને LED નો લાંબો પગ (Anode +) R1 સાથે જોડો.", "ब्रेडबोर्ड पर SW1 और R1 को सीरीज़ में जोड़ें व LED का एनोड (+) R1 से लगाएं।", "Connect SW1, R1, and LED1 (long Anode lead to R1) in series on breadboard.", "પોલેરિટી સાચી", "ध्रुवता सही", "Polarity verified", "LED1"),
      PracticalStepEntity("s_9_1_4", "prac_9_1", 4, false, "9V બેટરી જોડી SW1 ચાલુ કરો અને DMM ને 20V DC પર મૂકી LED પર વોલ્ટેજ (V_LED) માપો.", "9V बैटरी लगाकर SW1 ऑन करें और DMM से LED वोल्टेज (V_LED) मापें।", "Power with 9V, switch SW1 ON, and measure V_LED across LED1 (~2.0V) and current (~21mA).", "V_LED ≈ 2.0V, I ≈ 21mA", "V_LED ≈ 2.0V, I ≈ 21mA", "V_LED ≈ 2.0V, I ≈ 21mA", "SW1"),

      // --- Prac 9.2 ---
      PracticalStepEntity("s_9_2_1", "prac_9_2", 1, true, "સુરક્ષા: સેફ્ટી ચશ્માં પહેરો, બારી ખુલ્લી રાખો અને 25W સોલ્ડરિંગ આયર્ન સ્ટેન્ડમાં રાખો.", "सुरक्षा: सुरक्षा चश्मा पहनें और सोल्डरिंग आयरन को स्टैंड में रखें।", "Safety Check: Wear safety glasses, ventilate area, and keep hot iron in stand.", "PPE અને સ્ટેન્ડ તૈયાર", "PPE और स्टैंड तैयार", "Safety PPE ready", null),
      PracticalStepEntity("s_9_2_2", "prac_9_2", 2, false, "વેરોબોર્ડ પર R1 અને LED1 ગોઠવી 2–3 સેકન્ડ ગરમ કરી ચમકદાર શંકુ સોલ્ડર જોઇન્ટ બનાવો.", "वेरोबोर्ड पर R1 व LED1 लगाकर चमकदार सोल्डर जॉइंट बनाएं।", "Mount R1 & LED1 on veroboard, heat pad+lead 2–3s, and form shiny solder fillets.", "ચમકદાર જોઇન્ટ", "चमकदार जॉइंट", "Clean shiny fillets", "R1"),
      PracticalStepEntity("s_9_2_3", "prac_9_2", 3, false, "પાવર બંધ રાખી મલ્ટિમીટર કન્ટિન્યુઇટી (🔊) મોડમાં બધા જોઇન્ટ અને શોર્ટ-બ્રિજ તપાસો.", "बिना पावर के मल्टीमीटर कंटिन्यूटी (🔊) मोड से सभी जॉइंट जांचें।", "With power OFF, check joint continuity and zero short-bridges in DMM Beep mode.", "કન્ટિન્યુઇટી Beep OK", "कंटिन्यूटी Beep OK", "Beep confirmed", "LED1"),

      // --- Prac 9.3 ---
      PracticalStepEntity("s_9_3_1", "prac_9_3", 1, true, "ઉચ્ચ સુરક્ષા: ડેડ LED બલ્બને સીધા 230V માં ન લગાવો — હંમેશા સીરીઝ ટેસ્ટ લેમ્પ વાપરો.", "उच्च सुरक्षा: LED बल्ब को सीधे 230V में न लगाएं — हमेशा सीरीज़ टेस्ट लैंप उपयोग करें।", "Safety Check: Test ONLY via Series Test Lamp; never plug exposed bulb directly into 230V.", "સીરીઝ ટેસ્ટ બોર્ડ તૈયાર", "सीरीज़ टेस्ट बोर्ड तैयार", "Series lamp ready", "AC1"),
      PracticalStepEntity("s_9_3_2", "prac_9_3", 2, true, "સુરક્ષા: ડિફ્યુઝર ખોલ્યા પછી C1 (100µF/100V) કેપેસિટરને ઇન્સ્યુલેટેડ રેઝિસ્ટરથી ડિસ્ચાર્જ કરો.", "सुरक्षा: डिफ्यूज़र खोलने के बाद कैपेसिटर C1 को सुरक्षित डिस्चार्ज करें।", "Safety Check: Discharge HV capacitor C1 before touching driver PCB pads.", "C1 ડિસ્ચાર્જ થયેલ", "C1 डिस्चार्ज्ड", "C1 discharged", "C1"),
      PracticalStepEntity("s_9_3_3", "prac_9_3", 3, false, "DMM વડે ફ્યુઝિબલ રેઝિસ્ટર F1 (22Ω) અને બ્રિજ BR1 ડાયોડ્સની તપાસ કરો.", "DMM से फ्यूज़िबल रेजिस्टर F1 और ब्रिज BR1 डायोड की जांच करें।", "Probe F1 fusible resistor continuity and check BR1 bridge rectifier diodes with DMM.", "F1 અને BR1 ચકાસેલ", "F1 व BR1 जांचे गए", "F1 & BR1 tested", "F1"),
      PracticalStepEntity("s_9_3_4", "prac_9_3", 4, false, "MCPCB પર કાળું ટપકું પડેલ બળેલો SMD LED શોધી નવો MCPCB થર્મલ પેસ્ટ સાથે લગાવો અને ટેસ્ટ કરો.", "MCPCB पर खराब SMD LED पहचानकर थर्मल पेस्ट सहित नया MCPCB लगाएं।", "Inspect MCPCB for blackened dead LEDs, replace with thermal paste, and verify via Series Lamp.", "બલ્બ પ્રકાશિત થાય છે", "बल्ब ठीक से जल रहा है", "Bulb lights cleanly", "MCPCB"),

      // --- Prac 9.4 ---
      PracticalStepEntity("s_9_4_1", "prac_9_4", 1, true, "સુરક્ષા: ઇન્સ્યુલેટેડ ગ્લોવ્ઝ, રબર-સોલ શૂઝ અને સૂકી રબર મેટની હાજરી ચકાસો.", "सुरक्षा: इंसुलेटेड दस्ताने, रबर के जूते और सूखी रबर मैट की जांच करें।", "Safety Check: Inspect insulated gloves, rubber footwear, and dry floor mat.", "PPE 100% યોગ્ય", "PPE 100% सही", "PPE verified", null),
      PracticalStepEntity("s_9_4_2", "prac_9_4", 2, false, "CO₂ અગ્નિશામક પર PASS નિયમ (Pull-Aim-Squeeze-Sweep) અને RCCB ટેસ્ટ બટનનું નિદર્શન કરો.", "CO₂ फायर एक्सटिंग्विशर पर PASS विधि और RCCB टेस्ट बटन का प्रदर्शन करें।", "Demonstrate PASS sequence on CO₂ extinguisher and press RCCB Test button to verify trip.", "RCCB ટ્રીપ થાય છે", "RCCB ट्रिप होता है", "RCCB trips <40ms", null),
      PracticalStepEntity("s_9_4_3", "prac_9_4", 3, false, "વર્કશોપ કચરાને સૂકો કચરો, રિસાયક્લેબલ પ્લાસ્ટિક અને E-વેસ્ટ (PCB/બેટરી/LED) બિનમાં અલગ કરો.", "कचरे को सामान्य, प्लास्टिक और ई-कचरा (PCB/बैटरी/LED) बिन में अलग करें।", "Segregate workshop scrap into General, Recyclable, and Hazardous E-Waste bins.", "100% વર્ગીકરણ પૂર્ણ", "100% वर्गीकरण पूर्ण", "E-waste segregated", null),

      // --- Prac 10.1 ---
      PracticalStepEntity("s_10_1_1", "prac_10_1", 1, true, "સુરક્ષા: આયર્ન ઠંડું છે અને પાવર પ્લગ સોકેટની બહાર છે તેની ખાતરી કરો.", "सुरक्षा: सुनिश्चित करें कि आयरन ठंडा है और पावर प्लग बाहर निकला है।", "Safety Check: Confirm iron is unplugged and soleplate is at room temperature.", "પ્લગ બહાર છે", "प्लग बाहर है", "Unplugged & cool", "AC1"),
      PracticalStepEntity("s_10_1_2", "prac_10_1", 2, false, "DMM થી L–N વચ્ચે અવરોધ (~50–60Ω) અને E–સોલપ્લેટ વચ્ચે કન્ટિન્યુઇટી (<1Ω) માપો.", "DMM से L–N के बीच प्रतिरोध (~50–60Ω) और E–सोलप्लेट कंटिन्यूटी (<1Ω) मापें।", "Measure L–N resistance (~53Ω for 1000W) and Earth-to-Soleplate continuity (<1Ω).", "L-N ≈ 53Ω, E-Body <1Ω", "L-N ≈ 53Ω, E-Body <1Ω", "L-N ≈ 53Ω, E-Body <1Ω", "HE1"),
      PracticalStepEntity("s_10_1_3", "prac_10_1", 3, false, "બંને L અને N પિન થી મેટલ સોલપ્લેટ વચ્ચે મેગા-ઓહ્મ (OL) ચેક કરી લીકેજ નથી તે ખાતરી કરો.", "L व N पिन से मेटल सोलप्लेट के बीच अनंत प्रतिरोध (OL) जांचकर अर्थ लीकेज न होने की पुष्टि करें।", "Verify OL (infinite resistance) from both L and N prongs to metal soleplate before powering on.", "OL (લીકેજ નથી)", "OL (कोई लीकेज नहीं)", "OL (no earth leak)", "PE"),

      // --- Prac 10.2 ---
      PracticalStepEntity("s_10_2_1", "prac_10_2", 1, true, "સુરક્ષા: ઇસ્ત્રી અનપ્લગ કરી થર્મલ ફ્યુઝને ક્રિમ્પિંગ સ્લીવથી લગાવો (સોલ્ડર ન કરો).", "सुरक्षा: आयरन अनप्लग कर थर्मल फ्यूज़ को क्रिम्प स्लीव से लगाएं (सोल्डर न करें)।", "Safety Check: Unplug iron; prepare mechanical crimp sleeves (never solder thermal fuse).", "ક્રિમ્પ ટૂલ્સ તૈયાર", "क्रिम्प टूल्स तैयार", "Crimp sleeves ready", "TF1"),
      PracticalStepEntity("s_10_2_2", "prac_10_2", 2, false, "થર્મોસ્ટેટ TH1 ના કોન્ટેક્ટ પોઇન્ટ ફાઇન સેન્ડપેપરથી સાફ કરો અને નોબ ફેરવી કટ-ઓફ ક્લિક તપાસો.", "थर्मोस्टेट TH1 के कॉन्टैक्ट साफ करें और नॉब घुमाकर कट-ऑफ क्लिक जांचें।", "Polish thermostat TH1 contacts lightly and verify mechanical click across dial range.", "થર્મોસ્ટેટ ક્લિક OK", "थर्मोस्टेट क्लिक OK", "Thermostat clicks", "TH1"),
      PracticalStepEntity("s_10_2_3", "prac_10_2", 3, false, "નવો 240°C થર્મલ ફ્યુઝ TF1 ક્રિમ્પ કરો, અર્થિંગ જોડો અને સીરીઝ ટેસ્ટ લેમ્પથી ગરમી/કટ-ઓફ તપાસો.", "नया 240°C थर्मल फ्यूज़ TF1 क्रिम्प करें, अर्थिंग जोड़ें व सीरीज़ लैंप से कट-ऑफ जांचें।", "Crimp new 240°C TF1, reattach earth lead, and verify neon lamp + thermostat cutoff via Series Lamp.", "નિયોન કટ-ઓફ OK", "नियॉन कट-ऑफ OK", "Cutoff & neon OK", "NE1"),

      // --- Prac 10.3 ---
      PracticalStepEntity("s_10_3_1", "prac_10_3", 1, true, "સુરક્ષા: MCB બંધ કરો અને 2.5µF કેપેસિટરના ટર્મિનલ ઇન્સ્યુલેટેડ સ્ક્રુડ્રાઇવરથી ડિસ્ચાર્જ કરો.", "सुरक्षा: MCB बंद करें और 2.5µF कैपेसिटर पिन शॉर्ट कर डिस्चार्ज करें।", "Safety Check: Switch off MCB and discharge 2.5µF fan capacitor before probing.", "C1 ડિસ્ચાર્જ્ડ", "C1 डिस्चार्ज्ड", "C1 discharged", "C1"),
      PracticalStepEntity("s_10_3_2", "prac_10_3", 2, false, "મોટરના 3 વાયર વચ્ચે DMM થી અવરોધ માપો અને Common, Starting તથા Running વાયર નોંધો.", "मोटर के 3 तारों के बीच प्रतिरोध मापकर Common, Starting और Running तार नोट करें।", "Measure DMM ohms across all 3 fan wire pairs to identify Common, Start (Ls), and Run (Lm).", "C, Ls, Lm ઓળખાયા", "C, Ls, Lm की पहचान", "C, Ls, Lm mapped", "Ls"),
      PracticalStepEntity("s_10_3_3", "prac_10_3", 3, false, "ફેઝ લાઇનમાં રેગ્યુલેટર REG1, નવો 2.5µF C1 અને કોઇલ્સ જોડી પંખાની સાચી દિશા (Anti-clockwise) તપાસો.", "फेज लाइन में रेगुलेटर REG1, 2.5µF C1 और कॉइल जोड़कर सही घुमाव दिशा जांचें।", "Wire REG1 in Live line, connect C1 and windings, and confirm smooth anti-clockwise rotation.", "ઝડપ અને દિશા યોગ્ય", "गति व दिशा सही", "Speed & direction OK", "REG1"),

      // --- Prac 10.4 ---
      PracticalStepEntity("s_10_4_1", "prac_10_4", 1, true, "ઉચ્ચ સુરક્ષા: પાણી ટાંકી ભરતા કે તપાસતા પહેલાં કૂલરનો 3-પિન પ્લગ સંપૂર્ણ બહાર કાઢો.", "उच्च सुरक्षा: पानी और वायरिंग जांच से पहले कूलर का प्लग बाहर निकालें।", "Safety Check: Unplug cooler from mains before touching tank water, pump, or switches.", "પ્લગ બહાર છે", "प्लग बाहर है", "Unplugged", "AC1"),
      PracticalStepEntity("s_10_4_2", "prac_10_4", 2, false, "સબમર્સિબલ પંપ P1 નું ઇમ્પેલર અને મેશ ફિલ્ટર સાફ કરો અને DMM થી કોઇલ કન્ટિન્યુઇટી માપો.", "सबमर्सिबल पंप P1 का इम्पेलर और फिल्टर साफ कर DMM से कॉइल कंटिन्यूटी जांचें।", "Clean P1 pump impeller and mesh filter, and check winding continuity + zero body leak.", "P1 કોઇલ OK", "P1 कॉइल OK", "P1 coil OK", "P1"),
      PracticalStepEntity("s_10_4_3", "prac_10_4", 3, false, "રોટરી સ્વિચ SW1 (Low/Med/High) અને પંપ સ્વિચ SW2 જોડી પાણીના ફ્લો તથા અર્થિંગની તપાસ કરો.", "रोटरी स्विच SW1 और पंप स्विच SW2 जोड़कर पानी प्रवाह व अर्थिंग की जांच करें।", "Wire SW1 (3-speed) & SW2 (pump), verify airflow steps, water flow over pads, and earth continuity.", "હવા, પાણી અને અર્થિંગ OK", "हवा, पानी व अर्थिंग OK", "Air, pump & earth OK", "SW1"),
    )
}
